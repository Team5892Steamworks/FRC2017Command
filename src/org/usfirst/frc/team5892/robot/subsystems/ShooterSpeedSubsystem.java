package org.usfirst.frc.team5892.robot.subsystems;


import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public class ShooterSpeedSubsystem extends PIDSubsystem {

    // Initialize your subsystem here
	
	public static final double Kp = 0.5;
	public static final double Ki = 0.0;
	public static final double Kd = 0.0;
	public static final double FINAL_SPEED = 0.5;
	public static final double ZERO_SPEED = 0.0;
	
	private Victor motor = new Victor(Robot.map.flywheel.port);
	private Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
	@SuppressWarnings("deprecation")
	private AnalogInput encA = new AnalogInput(RobotMap.encoderAnalog);
	
    public ShooterSpeedSubsystem() {
    	super("ShooterSpeedSubsystem",Kp, Ki, Kd);
    	setSetpoint(FINAL_SPEED);
    	
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
        return encA.getVoltage();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	motor.set(output);
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
