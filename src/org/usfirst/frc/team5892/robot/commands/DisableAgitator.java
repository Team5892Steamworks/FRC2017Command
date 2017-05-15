package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.Agitator.AgitatorState;

/**
 *
 */
public class DisableAgitator extends Command {
	
	AgitatorState prev;
	public DisableAgitator() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.agitator_s);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		prev = Robot.agitator_s.getState();
		Robot.agitator_s.disable();
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
		Robot.agitator_s.enable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.agitator_s.enable();
	}
}
