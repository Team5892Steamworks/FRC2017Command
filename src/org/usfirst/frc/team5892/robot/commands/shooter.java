package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

public class shooter extends Command {
	Preferences prefs;
	Victor flywheel = new Victor(5);
	Victor feeder = new Victor(4);
	public shooter() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		flywheel.set(-0.7);
		Timer.delay(.7);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		feeder.set(.5);
		flywheel.set(-0.7);
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
		flywheel.set(0);
	}
  
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		feeder.set(0);
		flywheel.set(0);
	}
}
