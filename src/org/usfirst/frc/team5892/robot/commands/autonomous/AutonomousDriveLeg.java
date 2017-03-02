package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class AutonomousDriveLeg extends Command {
	
	double xAxis;
	double yAxis;
	double twist;
	double duration;
	
	public AutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double duration_) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		xAxis = -xAxis_;
		yAxis = -yAxis_;
		twist = -twist_;
        duration = duration_;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.mecanumDrive(xAxis, twist, yAxis);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.mecanumDrive(xAxis, twist, yAxis);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timeSinceInitialized() >= duration;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.mecanumDrive(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}