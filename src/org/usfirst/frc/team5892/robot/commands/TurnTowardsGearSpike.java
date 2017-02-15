package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class TurnTowardsGearSpike extends Command {
	NetworkTable table;
	
	final double KP = 0.2;
	final double KI = 0.2;
	final double KD = 0.2;
	
	final double desiredX = 0;
	
	double error_prior;
	double integral;
	
	double turnSpeed;
	
	boolean shootAfter;
	
	public TurnTowardsGearSpike(boolean doShootAfter) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		shootAfter = doShootAfter;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		table = NetworkTable.getTable("PixyVision");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double actualValue = table.getNumber("xpos1", -2);
		
		double error = desiredX - actualValue;
		integral = integral + (error*25);
		double derivative = (error - error_prior) * 25;
		double output = KP*error + KI*integral + KD*derivative;
		error_prior = error;
		
		Robot.drive.mecanumDrive(0, 0, output);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return table.getNumber("xpos1", -2) > desiredX - 20 ||
			   table.getNumber("xpos1", -2) < desiredX + 20;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		if (shootAfter) {
			// fire the machine gun pew pew pew
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
