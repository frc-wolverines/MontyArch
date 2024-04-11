package com.frc5274.lib.vision;

import java.util.function.Supplier;

import com.frc5274.lib.math.Angle2d;
import com.frc5274.lib.math.Coordinate2d;
import com.frc5274.lib.math.Math;

@SuppressWarnings("unused")
public class Limelight {
    private double xDimensionsFromCenter = 29.8;
    private double yDimensionsFromCenter = 24.85;

    private double xDimensionDegrees = Math.range(-xDimensionsFromCenter, xDimensionsFromCenter);
    private double yDimensionDegrees = Math.range(-yDimensionsFromCenter, yDimensionsFromCenter);

    private double xAdjustedDimensionsFromCenter = xDimensionsFromCenter;
    private double yAdjustedDimensionsFromCenter = yDimensionsFromCenter;

    private Coordinate2d crosshairPosition = new Coordinate2d(0, 0);

    private Supplier<Angle2d> targetPosition;
    private Supplier<Boolean> hasTarget;
    private final String limelightName;

    public Limelight (String limelight_name) {
        targetPosition = () -> new Angle2d(LimelightInterface.getTX(limelight_name), LimelightInterface.getTY(limelight_name));
        hasTarget = () -> LimelightInterface.getTV(limelight_name);
        limelightName = limelight_name;
    }

    public void setCrosshair(Coordinate2d crosshair_position) {
        crosshairPosition = crosshair_position;
    }

    public Coordinate2d getCoordinate() {
        Coordinate2d coordinates = new Coordinate2d(LimelightInterface.getTX(limelightName), LimelightInterface.getTY(limelightName));
        return coordinates;
    }

    public Coordinate2d getNormalizedCoordinate() {
        Coordinate2d coordinates = 
            new Coordinate2d (
                getCoordinate().x, 
                getCoordinate().y, 
                xDimensionsFromCenter, 
                yDimensionsFromCenter
            );

        return coordinates;
    }
}
