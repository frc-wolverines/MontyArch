package com.frc5274.robot.subsystems.modules;

import com.ctre.phoenix6.hardware.CANcoder;
import com.frc5274.lib.config.PIDConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class KrakenModuleIO {
    
    private final TalonFX driveMotor;
    private final TalonFX pivotMotor;

    private final CANcoder moduleEncoder;

    private static PIDController angleController = new PIDController(0, 0, 0);
    private static double maxModuleSpeed = 1.0;
    private static double trackConversionFactor = 0.0;
    private static double pivotConversionFactor = 0.0;
    private final boolean moduleInverted;

    /**
     * Creates a new instance of SparkModuleIO
     * @param config the module config to initialize and setup hardware devices
     */
    public KrakenModuleIO(ModuleConfig config) {
        driveMotor = new TalonFX(config.drive_motor_id);
        driveMotor.setInverted(config.drive_motor_direction.isInverted());
        driveMotor.setNeutralMode(ModuleConfig.drive_motor_behavior.toNeutralMode());

        pivotMotor = new TalonFX(config.pivot_motor_id);
        pivotMotor.setInverted(config.pivot_motor_direction.isInverted());
        pivotMotor.setNeutralMode(ModuleConfig.pivot_motor_behavior.toNeutralMode());

        moduleEncoder = new CANcoder(config.absolute_encoder_id);

        moduleInverted = config.absolute_encoder_reversed;
    }

    //Global Configuration
    public static void setAnglePIDConstants(PIDConstants constants) {
        angleController = constants.toController();
    }

    public static void setMaxModuleSpeed(double max_speed_meters) {
        maxModuleSpeed = max_speed_meters;
    }

    public static void configureConversions(double track_diameter, double track_gear_ratio, double pivot_gear_ratio) {
        trackConversionFactor = (track_gear_ratio) * (track_diameter * Math.PI);
        pivotConversionFactor = (2 * Math.PI) * (pivot_gear_ratio);
    }

    //Encoder Management
    public double getTrackVelocity() {
        return driveMotor.getVelocity() * trackConversionFactor;
    }

    public double getTrackPosition() {
        return driveMotor.getPosition() * trackConversionFactor;
    }

    public double getModuleAngleVelocity() {
        return pivotMotor.getVelocity() * pivotConversionFactor;
    }

    public double getModuleAngle() {
        return pivotMotor.getPosition() * pivotConversionFactor;
    }

    public double getAbsoluteModuleAngle() {
        return moduleInverted ? 
            -moduleEncoder.getAbsolutePosition().getValueAsDouble() : moduleEncoder.getAbsolutePosition().getValueAsDouble();
    }

    public Rotation2d getModuleRotation2d() {
        return Rotation2d.fromRadians(getModuleAngle());
    }

    public void resetModuleData() {
        driveMotor.setPosition(0);
        pivotMotor.setPosition(0);
    }

    public void calibrateModuleAngle() {
        pivotMotor.setPosition(getModuleAngle());
    }

    //Control
    public void setDesiredState(SwerveModuleState desired_state) {

        if (desired_state.speedMetersPerSecond < 0.001) {
            stop();
            return;
        }

        driveMotor.set(desired_state.speedMetersPerSecond / maxModuleSpeed);
        pivotMotor.set(angleController.calculate(getModuleAngle(), desired_state.angle.getRadians()));
    }

    public void stop() {
        driveMotor.stopMotor();
        pivotMotor.stopMotor();
    }