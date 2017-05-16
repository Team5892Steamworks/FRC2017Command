package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//@Deprecated
public class shooter extends Command {
	
	final double defaultPower = 0.7;
	double power;
	
	public shooter() {
		//duration = -1;
		power = defaultPower;
	}
	
	public shooter(double power_) {
		power = power_;
	}
	
	/*public shooter(boolean constructor, double duration_) {
		// Use requires() here to declare subsystem dependencies
		duration = duration_;
	}*/

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.flywheel.set(-power);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		/*if (duration < 0) {
			if (Math.abs(Robot.oi.copilot.getRawAxis(1)) > 0.2) power += Robot.oi.copilot.getRawAxis(1);
			power += Robot.oi.copilot.getRawAxis(1);
			if (power > 1) power = 1;
			if (power < 0) power = 0;
			SmartDashboard.putNumber("Shooter Power", power);
			flywheel.set(-power);
		}*/
		
		//if (timeSinceInitialized() > 2) feeder.set(.65);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; //duration > 0 && timeSinceInitialized() >= duration;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//feeder.set(0);
		Robot.flywheel.set(0);
	}
  
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
