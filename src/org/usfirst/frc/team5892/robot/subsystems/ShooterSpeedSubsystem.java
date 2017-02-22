package org.usfirst.frc.team5892.robot.subsystems;


import org.usfirst.frc.team5892.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;



public class ShooterSpeedSubsystem extends PIDSubsystem {

    // Initialize your subsystem here
	
	public static final double Kp = 0.5;
	public static final double Ki = 0.0;
	public static final double Kd = 0.0;
	public static final double FINAL_SPEED = 0.5;
	public static final double ZERO_SPEED = 0.0;
	
	private Victor motor;
	private Encoder enc = new Encoder(7, 8, false, Encoder.EncodingType.k2X);
	//private AnalogInput encA = new AnalogInput(RobotMap.encoderAnalog);
	
    public ShooterSpeedSubsystem() {
    	super("ShooterSpeedSubsystem",Kp, Ki, Kd);
    	setSetpoint(FINAL_SPEED);
    	//motor  = new Victor(RobotMap.flywheel);
    	
    	enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return enc.getRate();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	motor.pidWrite(output);
    }

    //To display encoder values to Smart Dashboard
	public Encoder getEncoderVal() {
		return enc;
	}

	//redundant method, simply here to suppress a warning 
	public void setEnccoderVal(Encoder enc) {
		this.enc = enc;
	}
}
