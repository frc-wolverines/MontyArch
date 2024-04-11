package com.frc5274.lib.interfaces;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface SwerveDrive {
    
    public abstract SwerveModuleState[] getModuleStates();
    public abstract SwerveModulePosition[] getModulePositions();
    public abstract void resetModules();

}
