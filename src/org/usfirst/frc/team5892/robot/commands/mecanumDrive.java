package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
		/*
		double x;
		double y;
		double twist;
		if(Robot.oi.pilot.getX() >= .18){
			x = Robot.oi.pilot.getX();
		}else{
			x = 0;
		}
		if(Robot.oi.pilot.getRawAxis(1) >= .18){
			y = Robot.oi.pilot.getRawAxis(1);
		}else{
			y = 0;
		}
		if(Robot.oi.pilot.getRawAxis(4) >= .18){
			twist = Robot.oi.pilot.getRawAxis(4);
		}else{
			twist = 0;
		}
		*/
		Robot.drive.mecanumDrive(Robot.oi.pilot.getRawAxis(0), Robot.oi.pilot.getRawAxis(1), Robot.oi.pilot.getRawAxis(4));
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
