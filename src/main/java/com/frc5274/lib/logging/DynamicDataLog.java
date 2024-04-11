package com.frc5274.lib.logging;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**A class that shortens the Smartdashboard methods to one universal method for all data types */
public class DynamicDataLog {
    /**
     * Logs a double to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's value
     */
    public static void log(String key, double value) {
        SmartDashboard.putNumber(key, value);
    }

    /**
     * Logs a double array to Smartdashboard
     * @param key the data entry's id
     * @param values the data entry's values
     */
    public static void  log(String key, double[] values) {
        SmartDashboard.putNumberArray(key, values);
    }

    /**
     * Logs a string to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's value
     */
    public static void log(String key, String value) {
        SmartDashboard.putString(key, value);
    }

    /**
     * Logs a string array to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's values
     */
    public static void log(String key, String[] values) {
        SmartDashboard.putStringArray(key, values);
    }

    /**
     * Logs a boolean to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's value
     */
    public static void log(String key, Boolean value) {
        SmartDashboard.putBoolean(key, value);
    }

    /**
     * Logs a boolean array to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's values
     */
    public static void log(String key, Boolean[] values) {
        SmartDashboard.putBooleanArray(key, values);
    }

    /**
     * Logs a Sendable variable to Smartdashboard
     * @param key the data entry's id
     * @param value the data entry's value
     */
    public static void log(String key, Sendable value) {
        SmartDashboard.putData(key, value);
    }
}
