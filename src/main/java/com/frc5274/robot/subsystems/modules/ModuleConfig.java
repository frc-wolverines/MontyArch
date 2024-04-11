package com.frc5274.robot.subsystems.modules;

import com.frc5274.lib.config.Direction.MotorDirection;
import com.frc5274.lib.config.MotorBehavior.IdleBehavior;

public class ModuleConfig {
    public final int drive_motor_id;
    public final int pivot_motor_id;
    public final int absolute_encoder_id;

    public final MotorDirection drive_motor_direction;
    public final MotorDirection pivot_motor_direction;
    public final boolean absolute_encoder_reversed;

    public static IdleBehavior drive_motor_behavior = IdleBehavior.BRAKE;
    public static IdleBehavior pivot_motor_behavior = IdleBehavior.COAST;

    public ModuleConfig(
        int drive_id,
        int pivot_id,
        int encoder_id,
        MotorDirection drive_direction,
        MotorDirection pivot_direction,
        boolean encoder_reversed
    ) {
        drive_motor_id = drive_id;
        pivot_motor_id = pivot_id;
        absolute_encoder_id = encoder_id;

        drive_motor_direction = drive_direction;
        pivot_motor_direction = pivot_direction;
        absolute_encoder_reversed = encoder_reversed;
    }

    public static void setMotorIdleBehaviors(IdleBehavior drive_behavior, IdleBehavior pivot_behavior) {
        drive_motor_behavior = drive_behavior;
        pivot_motor_behavior = pivot_behavior;
    }
}
