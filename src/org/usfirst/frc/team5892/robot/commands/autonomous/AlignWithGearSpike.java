package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AlignWithGearSpike extends Command {
	NetworkTable table;
	
	final double threshold = 20;
	
	final double KP = 0.2;
	final double KI = 0.2;
	final double KD = 0.2;
	
	final double desiredX = 0;
	
	double error_prior;
	double integral;
	
	double turnSpeed; 
	
	public AlignWithGearSpike() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
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
		
		Robot.drive.mecanumDrive(0, output, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return table.getNumber("xpos1", -2) > desiredX - threshold ||
			   table.getNumber("xpos1", -2) < desiredX + threshold;
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
