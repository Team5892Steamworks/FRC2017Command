package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PushGear extends Command {
    
	@Override
	protected void initialize() {
		Robot.pneumatics.gearPush.set(true);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.pneumatics.gearPush.set(false);
	}

}
