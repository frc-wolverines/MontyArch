package com.frc5274.lib.config;

public class Direction {
    public enum MotorDirection {
        CLOCKWISE,
        COUNTER_CLOCKWISE;

        public boolean isInverted() {
            return this == CLOCKWISE;
        }
    }
}
