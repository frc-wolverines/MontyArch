package com.frc5274.lib.math;

/**A class that stores the location of an object using a pair of angles */
public class Angle2d {
    public double angle_y;
    public double angle_x;

    /**Constructs a new instance of Angle2d with values of 0.0 */
    public Angle2d() {
        angle_x = 0.0;
        angle_y = 0.0;
    }

    /**
     * Constructs a new instance of Angle2d with the positives being up and right
     * @param angle_x the angle value of the x axis, positive is right
     * @param angle_y the angle value of the y axis, positive is up
     */
    public Angle2d(double angle_x, double angle_y) {
        this.angle_x = angle_x;
        this.angle_y = angle_y;
    }
}
