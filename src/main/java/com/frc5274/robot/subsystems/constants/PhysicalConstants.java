package com.frc5274.robot.subsystems.constants;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class PhysicalConstants {
    
    public static final double trackWidth = Units.inchesToMeters(29.0);
    public static final double trackLength = Units.inchesToMeters(29.0);

    public class ModuleTranslations {
        public static final Translation2d LEFT_FRONT = new Translation2d(trackLength / 2, trackWidth / 2);
        public static final Translation2d RIGHT_FRONT = new Translation2d(trackLength / 2, -trackWidth / 2);
        public static final Translation2d LEFT_BACK = new Translation2d(-trackLength / 2, trackWidth / 2);
        public static final Translation2d RIGHT_BACK = new Translation2d(-trackLength / 2, -trackWidth / 2);
    }

    public static final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        ModuleTranslations.LEFT_FRONT,
        ModuleTranslations.RIGHT_FRONT,
        ModuleTranslations.LEFT_BACK,
        ModuleTranslations.RIGHT_BACK
    );
}
