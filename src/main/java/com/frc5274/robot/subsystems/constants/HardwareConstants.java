package com.frc5274.robot.subsystems.constants;

import com.frc5274.lib.config.Direction.MotorDirection;
import com.frc5274.robot.subsystems.modules.ModuleConfig;

import edu.wpi.first.math.util.Units;

public class HardwareConstants {
    
    public static final double maxNeoModuleSpeed = Units.feetToMeters(16.6);
    public static final double maxKrakenModuleSpeed = Units.feetToMeters(17.1);

    public class ModuleConfigs {
        public static final ModuleConfig LEFT_FRONT = new ModuleConfig(
            2, 
            3, 
            4, 
            MotorDirection.CLOCKWISE, 
            MotorDirection.CLOCKWISE,
            true
        );

        public static final ModuleConfig LEFT_BACK = new ModuleConfig(
            5, 
            6, 
            7, 
            MotorDirection.CLOCKWISE, 
            MotorDirection.CLOCKWISE,
            true
        );

        public static final ModuleConfig RIGHT_BACK = new ModuleConfig(
            8, 
            9, 
            10, 
            MotorDirection.COUNTER_CLOCKWISE, 
            MotorDirection.CLOCKWISE,
            true
        );

        public static final ModuleConfig RIGHT_FRONT = new ModuleConfig(
            11, 
            12, 
            13, 
            MotorDirection.COUNTER_CLOCKWISE, 
            MotorDirection.CLOCKWISE,
            true
        );
    }
}
