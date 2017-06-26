package org.usfirst.frc.team5892.robot.subsystems.sensors;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

@Deprecated
public class SensorArray extends Subsystem {
    
	Counter r_encoderLeft = new Counter(Robot.map.encoderLeft);
	public Sensor encoderLeft = new Sensor("Left Encoder", r_encoderLeft::get);
	
	Counter r_encoderRight = new Counter(Robot.map.encoderRight);
	public Sensor encoderRight = new Sensor("Right Encoder", r_encoderRight::get);
	
	AnalogInput r_ultrasonic = new AnalogInput(Robot.map.ultrasonic);
	public Sensor ultrasonic = new Sensor("Ultrasonic Sensor", r_ultrasonic::getVoltage);
	
	Sensor[] allSensors = new Sensor[]{encoderLeft, encoderRight, ultrasonic};
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SensorOutput(allSensors));
	}
	
	public void resetEncoders() {
		r_encoderLeft.reset();
		r_encoderRight.reset();
	}

}
