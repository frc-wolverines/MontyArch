package com.frc5274.lib.math;

public class Coordinate2d {
    public double x, y = 0.0;

    public double bounds_x, bounds_y = 0.0;

    public Coordinate2d() {};

    public Coordinate2d(double x_position, double y_position) {
        x = x_position;
        y = y_position;
        bounds_x = 1.0;
        bounds_y = 1.0;
    }

    public Coordinate2d(double x_position, double y_position, double x_bounds, double y_bounds) {
        x = x_position;
        y = y_position;
        bounds_x = x_bounds;
        bounds_y = y_bounds;
    }

    public Coordinate2d getCoordinatePercentage() {
        double x_percentage = x >= 0 ? x / bounds_x : x / -bounds_x;
        double y_percentage = y >= 0 ? y / bounds_y : y / -bounds_y;

        return new Coordinate2d(x_percentage, y_percentage);
    }

    public double getDistance(Coordinate2d f1, Coordinate2d f2) {
        double x_delta = f1.x >= f2.x ? f1.x - f2.x : f2.x - f1.x;
        double y_delta = f1.y >= f2.y ? f1.y - f2.y : f2.y - f1.y;

        return java.lang.Math.sqrt(java.lang.Math.pow(x_delta, 2) + java.lang.Math.pow(y_delta, 2));
    }
}
