package com.frc5274.robot.subsystems.modules;

import com.ctre.phoenix6.hardware.CANcoder;
import com.frc5274.lib.config.PIDConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SparkModuleIO {
    
    private final CANSparkMax driveMotor;
    private final CANSparkMax pivotMotor;

    private final RelativeEncoder trackEncoder, pivotEncoder;
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
    public SparkModuleIO(ModuleConfig config) {
        driveMotor = new CANSparkMax(config.drive_motor_id, MotorType.kBrushless);
        driveMotor.setInverted(config.drive_motor_direction.isInverted());
        driveMotor.setIdleMode(ModuleConfig.drive_motor_behavior.toIdleMode());

        pivotMotor = new CANSparkMax(config.pivot_motor_id, MotorType.kBrushless);
        pivotMotor.setInverted(config.pivot_motor_direction.isInverted());
        pivotMotor.setIdleMode(ModuleConfig.pivot_motor_behavior.toIdleMode());

        trackEncoder = driveMotor.getEncoder();
        pivotEncoder = pivotMotor.getEncoder();
        moduleEncoder = new CANcoder(config.absolute_encoder_id);

        moduleInverted = config.absolute_encoder_reversed;

        configurePivotConstants();
        configureTrackConstants();
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
        return trackEncoder.getVelocity();
    }

    public double getTrackPosition() {
        return trackEncoder.getPosition();
    }

    public double getModuleAngleVelocity() {
        return pivotEncoder.getVelocity();
    }

    public double getModuleAngle() {
        return pivotEncoder.getPosition();
    }

    public double getAbsoluteModuleAngle() {
        return moduleInverted ? 
            -moduleEncoder.getAbsolutePosition().getValueAsDouble() : moduleEncoder.getAbsolutePosition().getValueAsDouble();
    }

    public Rotation2d getModuleRotation2d() {
        return Rotation2d.fromRadians(getModuleAngle());
    }

    public void resetModuleData() {
        trackEncoder.setPosition(0);
        pivotEncoder.setPosition(0);
    }

    public void calibrateModuleAngle() {
        pivotEncoder.setPosition(getModuleAngle());
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

    //Configuration
    public void configureTrackConstants() {
        trackEncoder.setPositionConversionFactor(trackConversionFactor);
        trackEncoder.setVelocityConversionFactor(trackConversionFactor / 60);
    }

    public void configurePivotConstants() {
        trackEncoder.setPositionConversionFactor(pivotConversionFactor);
        trackEncoder.setVelocityConversionFactor(pivotConversionFactor / 60);
    }
}
