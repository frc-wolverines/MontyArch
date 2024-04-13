package com.frc5274.lib.framework.requests;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Request {

    public List<SubsystemBase> usedSubsystems = new ArrayList<SubsystemBase>();
    public List<Boolean> requirements = new ArrayList<Boolean>();
    public double startTimestamp = 0.0;
    public boolean isQueued = false;

    public Request() {
        startTimestamp = DriverStation.getMatchTime();
    }

    public void addSubsystems(SubsystemBase... subsystems) {
        for(SubsystemBase required_subsystem : subsystems) {
            usedSubsystems.add(required_subsystem);
        }
    }

    public void addRequirements(Boolean... conditions) {
        for(Boolean condition : conditions) {
            requirements.add(condition);
        }
    }

    public boolean requirementsSatisfied() {
        boolean satisfied = true;

        for (Boolean requirement : requirements) {
            satisfied = requirement;
            if(satisfied == false) return false;
        }

        return satisfied;
    }

    public abstract void initialize();
    public abstract void execute();
    public abstract void disable(boolean overrided);
    public abstract void end();
}
