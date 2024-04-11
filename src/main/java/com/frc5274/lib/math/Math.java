package com.frc5274.lib.math;

public class Math {
    
    /**
     * Outputs a value that is locked to be in between a min and max value
     * @param value the number which will be modified to fit into given limits
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @return a value that is limited to be in between a min and max value
     */
    public static double clip(double value, double min, double max) {
        return java.lang.Math.max(min, java.lang.Math.min(max, value));
    }

    /**
     * Copies the functionality of Math.IEEEremainder but makes it more understandable
     * @param x1 one value to compute
     * @param x2 a second value to compute
     * @return the difference between the two values in IEEE 754 Format
     */
    public static double remainder(double x1, double x2) {
        return java.lang.Math.IEEEremainder(x1, x2);
    }
    
    /**
     * Discards a value if it is within a certain threshold
     * @param value the number that will be affected
     * @param threshold the value in which a -threshold to threshold deadzone will be incurred using
     * @return a value, outside of a given threshold, otherwise it is 0.0
     */
    public static double threshold(double value, double threshold) {
        return java.lang.Math.abs(value) >= threshold ? value : 0.0;
    }

    /**
     * Finds the range of a set of numbers
     * @param values any numbers that will be used to find a range
     * @return the range of the given values
     */
    public static double range(double... values) {
        double lower_bound = values[0];
        double upper_bound = values[0];

        for  (int i = 0; i < values.length; i++) {
            if (values[i] > upper_bound) {
                upper_bound = values[i];
            }
            if (values[i] < lower_bound) {
                lower_bound = values[i];
            }
        }

        return upper_bound - lower_bound;
    }
}
