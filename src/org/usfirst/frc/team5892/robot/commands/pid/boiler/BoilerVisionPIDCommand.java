package org.usfirst.frc.team5892.robot.commands.pid.boiler;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class BoilerVisionPIDCommand extends Command {
	
	private static BoilerVisionPIDController control = new BoilerVisionPIDController();
	
	public BoilerVisionPIDCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		control.enable();
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
		control.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		control.disable();
	}
}
