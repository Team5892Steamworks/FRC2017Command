package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DecreaseDriveBase extends Command {
	
	double dec;
	public DecreaseDriveBase(double dec_) {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		dec = dec_;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.set_base(Robot.drive.get_base() - dec);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
