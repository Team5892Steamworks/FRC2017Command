package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {

	Victor shooter = new Victor(Robot.map.flywheel.port);
	Encoder tach = new Encoder(8, 7);
	
    public Shooter(double p, double i, double d, double period, double f) {
		super(p, i, d, period, f); // Tune these
		tach.setDistancePerPulse(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	tach.getRate(); // In units/sec after scaling
    }
    
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return tach.getRate();
	}
	@Override
	protected void usePIDOutput(double output) {
		shooter.set(output);
	}
	
	public void setSpeed(double setpoint) {
		super.setSetpoint(setpoint);
	}
	
	public void disablePID(){
		super.disable();
	}
	
	public void enablePID() {
		super.enable();
	}
	
	public void setRawPower(double power) {
		disablePID();
		shooter.set(power);
	}
}