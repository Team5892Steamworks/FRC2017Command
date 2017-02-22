package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Not actually a P loop apparently maybe, it is what I came up with when presented with the goal.
 * -Kai
 */
public class ShooterPControlSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
    public static final double Kp = 0.9;
    private Encoder enc = new Encoder(7, 8, false, Encoder.EncodingType.k2X);
    private Victor motor = new Victor(1);
    private double power = 0;
    private boolean going = false;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public void enable(double startingPower) {
		motor.set(startingPower);
		power = startingPower;
		going = true;
	}
	
	public double PControl(double desiredSpeed) { // 0.6 power
		double currentSpeed = enc.getRate();
		double speedProportion = desiredSpeed / currentSpeed;
		double desiredPower = power * speedProportion;
		power += Kp * (power - desiredPower);
		motor.set(power);
		
		SmartDashboard.putNumber("Encoder Value", currentSpeed);
		SmartDashboard.putNumber("Speed Proportion", speedProportion);
		SmartDashboard.putNumber("Desired Power", desiredPower);
		SmartDashboard.putNumber("Actual Power", power);
		
	    return desiredSpeed - currentSpeed;
	}
	
	public void disable() {
		motor.set(0);
		going = false;
	}
}
