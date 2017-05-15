package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasonicShoot extends Command {
	
	public static AnalogInput ultrasonic = new AnalogInput(0);
	
	public UltrasonicShoot() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
	}
	
	protected double calculate(double input) {
		return .0045780594 * input + 45.86842105;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		shooter.flywheel.set(1);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double voltage = ultrasonic.getVoltage();
		SmartDashboard.putNumber("Ultrasonic Sensor", voltage);
		shooter.flywheel.set(voltage);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		shooter.flywheel.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
