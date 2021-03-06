package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;
//import org.usfirst.frc.team5892.robot.subsystems.Agitator.AgitatorState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EnableAgitator extends Command {
	
	//AgitatorState prev;
	public EnableAgitator() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//prev = Robot.agitator.getState();
		Robot.agitator.set(-1);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.agitator.set(-1);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.agitator.set(0);
	}
}
