package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class ActivateFeeder extends Command {
	public static Victor feeder = new Victor(Robot.map.feeder.port);
	
	public ActivateFeeder() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		feeder.set(.65);
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
		feeder.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		feeder.set(0);
	}
}
