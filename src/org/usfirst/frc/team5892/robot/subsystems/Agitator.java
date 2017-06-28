package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@Deprecated
public class Agitator extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public enum AgitatorState {
		ENABLED,
		DISABLED,
		REVERSED;
	}
	
	public Victor agitator = Robot.agitator;
	public final double power = -0.5;
    private AgitatorState state = AgitatorState.DISABLED;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public AgitatorState getState() {
    	return state;
    }
    
    public void enable() {
    	agitator.set(power);
    	state = AgitatorState.ENABLED;
    }
    
    public void disable() {
    	agitator.set(0);
    	state = AgitatorState.DISABLED;
    }
    
    public void reverse() {
    	if (state == AgitatorState.ENABLED) {
    		agitator.set(-power);
    		state = AgitatorState.REVERSED;
    	} else if (state == AgitatorState.REVERSED) {
    		agitator.set(power);
    		state = AgitatorState.ENABLED;
    	}
    }
}

