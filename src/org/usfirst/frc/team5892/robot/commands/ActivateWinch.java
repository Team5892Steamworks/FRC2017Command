package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateWinch extends Command {
	
	private double power;
	public ActivateWinch(double power_) {
		// Use requires() here to declare subsystem dependencies
		power = power_;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.winch.set(power);
		//Robot.lights.setRainbow(true);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.winch.set(0);
		//Robot.lights.setRainbow(false);
	}
}
