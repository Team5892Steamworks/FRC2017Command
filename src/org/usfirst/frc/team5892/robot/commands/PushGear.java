package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PushGear extends Command {
    
	public PushGear(boolean autoRetract) {
		if (autoRetract) setTimeout(0.75);
	}
	
	@Override
	protected void initialize() {
		Robot.pneumatics.gearPush.set(true);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.pneumatics.gearPush.set(false);
	}

}
