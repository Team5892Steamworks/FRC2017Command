package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

/**
 *
 */
public class PControlShoot extends Command {
	
	private Victor feeder = new Victor(RobotMap.feeder);
	public PControlShoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooterPControl);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.shooterPControl.enable(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shooterPControl.PControl(40000);
		feeder.set(.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shooterPControl.disable();
		feeder.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.shooterPControl.disable();
		feeder.set(0);
	}
}
