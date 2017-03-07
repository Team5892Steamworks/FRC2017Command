package org.usfirst.frc.team5892.robot.commands;


import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class mecanumDrive extends Command {
	public mecanumDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double base = Robot.drive.get_base();
		SmartDashboard.putNumber("Drive Base Multiplier", base);
		double mult = Robot.oi.pilot.getRawButton(5) ? 0.5 * base : base;
		Robot.drive.mecanumDrive(-Robot.oi.pilot.getRawAxis(0)*mult, Robot.oi.pilot.getRawAxis(4)*mult, Robot.oi.pilot.getRawAxis(1)*mult);
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
