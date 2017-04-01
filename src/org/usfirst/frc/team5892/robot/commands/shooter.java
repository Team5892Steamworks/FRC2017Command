package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//@Deprecated
public class shooter extends Command {
	//Preferences prefs;
	static Victor flywheel = new Victor(Robot.map.flywheel.port);
	static Victor feeder = new Victor(Robot.map.feeder.port);
	double duration;
	
	final double defaultPower = 0.632;
	double power = defaultPower;
	
	public shooter() {
		duration = -1;
	}
	
	public shooter(double duration_) {
		// Use requires() here to declare subsystem dependencies
		duration = duration_;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		flywheel.set(-power);
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
		
		if (timeSinceInitialized() > 0.7) feeder.set(.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return duration > 0 && timeSinceInitialized() >= duration;
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
