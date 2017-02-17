package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class shooter extends Command {
	Victor flywheel = new Victor(1);
	Victor feeder = new Victor(4);
	Victor agitator = new Victor(0);
	public shooter() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		flywheel.set(-.7);
		Timer.delay(.2);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		feeder.set(.7);
		flywheel.set(-.73);
		agitator.set(-.5);
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
