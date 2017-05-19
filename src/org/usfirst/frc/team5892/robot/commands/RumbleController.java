package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class RumbleController extends Command {
	
	double duration = -1;
	double power = 1;
	GenericHID.RumbleType type = GenericHID.RumbleType.kRightRumble;
	
	public RumbleController() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
	}
	
	public RumbleController(double duration) {
		this.duration = duration;
	}
	
	public RumbleController(double duration, double power) {
		this.duration = duration;
		this.power = power;
	}
	
	public RumbleController(GenericHID.RumbleType type) {
		this.type = type;
	}
	
	public RumbleController(double duration, GenericHID.RumbleType type) {
		this.duration = duration;
		this.type = type;
	}
	
	public RumbleController(double duration, double power, GenericHID.RumbleType type) {
		this.duration = duration;
		this.power = power;
		this.type = type; 
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	    Robot.oi.pilot.setRumble(type, power);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return duration > 0 && timeSinceInitialized() > duration;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.oi.pilot.setRumble(type, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.oi.pilot.setRumble(type, 0);
	}
}
