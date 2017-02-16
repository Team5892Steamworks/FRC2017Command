package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class agitator extends Command {
	Victor motor = new Victor(0);
	
	static boolean forwards = true;
	
	public agitator() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		motor.set(forwards ? 0.5 : -0.5);
		forwards = !forwards;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
<<<<<<< HEAD
		motor.set(-0.5);
=======
		
>>>>>>> 97f85d66e6960a8278e6c92eec9783fdab28ff39
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		motor.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
