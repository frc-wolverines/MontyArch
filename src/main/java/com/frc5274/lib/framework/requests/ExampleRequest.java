package com.frc5274.lib.framework.requests;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleRequest extends Request {

    SubsystemBase exampleSubsystem = new SubsystemBase() {
        
    };

    public ExampleRequest() {
        
        addSubsystems(exampleSubsystem);
        addRequirements(false, true, false);
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public void disable(boolean overrided) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }

    @Override
    public void end() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'end'");
    }
    
}
