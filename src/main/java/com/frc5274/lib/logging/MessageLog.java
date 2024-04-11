package com.frc5274.lib.logging;

import edu.wpi.first.wpilibj.DriverStation;

/**A class that handles a system output using different classifications of importance */
public class MessageLog {
    
    /**
     * Outputs a new system line
     * @param message the text to appear in the output
     * @param type the MessageType that will justify its color and importance
     */
    public MessageLog(String message, MessageType type) {
        switch (type) {
            case ERROR: DriverStation.reportError(message, false);
            case INFORMATION: System.out.println(TerminalColors.ANSI_PURPLE + message);
            case SUCCESS: System.out.println(TerminalColors.ANSI_GREEN + message);
            case WARNING: DriverStation.reportWarning(message, false);
            default: break;
        }
    }

    /**MessageType handles enumerators representing types of output */
    public enum MessageType {
        INFORMATION,
        SUCCESS,
        WARNING,
        ERROR    
    }
}
