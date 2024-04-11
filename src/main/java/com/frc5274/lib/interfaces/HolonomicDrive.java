package com.frc5274.lib.interfaces;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

public interface HolonomicDrive {

    public abstract double getHeading();
    public abstract Rotation2d getRotation2d();
    public abstract void resetHeading();

    public abstract ChassisSpeeds getChassisSpeeds();

    public abstract void setDesiredSpeed(ChassisSpeeds desired_speeds);
    public abstract void stop();

}
