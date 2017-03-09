package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class AccelerometerUpdate extends Command {
	
	BuiltInAccelerometer acc = new BuiltInAccelerometer();
	final double fps = 32.17404855643044;
	final double mps = 9.80665;
	private int speedX = 0;
	private int speedZ = 0;
	private double startTime;
	private double vI = 0; //initial velocity
	
	public AccelerometerUpdate() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.accelerometer);
	}


	
	
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		this.startTime = Timer.getFPGATimestamp();
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double x = acc.getX() * fps;
		double z = acc.getZ() * fps;
		SmartDashboard.putNumber("Accelerometer X", x);
		SmartDashboard.putNumber("Accelerometer Z", z);
		SmartDashboard.putNumber("Speed X", calcSpeed(x));
		SmartDashboard.putNumber("Speed Z", calcSpeed(z));
		
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
	
	private double calcSpeed(Double a){
		double speed = 0;
		double t = this.getElapsedTime();
		speed = (a*t)+vI;
		return speed;
	}
	
	private double getElapsedTime(){
		double currentTime = Timer.getFPGATimestamp();
		double elapsedTime = currentTime - startTime;
		return elapsedTime; //seconds 
	}
}
