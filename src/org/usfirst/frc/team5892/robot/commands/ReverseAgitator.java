package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseAgitator extends Command {
	public ReverseAgitator() {
		setTimeout(5);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.agitator.set(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.agitator.set(0);
	}
}
