package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.mecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/*
	 *     - PWM 7 - Connected to front left drive motor
	 *     - PWM 2 - Connected to rear left drive motor
	 *     - PWM 8 - Connected to front right drive motor
	 *     - PWM 3 - Connected to rear right drive motor
	 */
	RobotDrive m_robotDrive = new RobotDrive(Robot.map.driveTrain[0].port,
			Robot.map.driveTrain[1].port,
			Robot.map.driveTrain[2].port,
			Robot.map.driveTrain[3].port);
	double base = 1;
	
	public Drive() {
		m_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, Robot.map.driveTrain[0].inverted);
		m_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, Robot.map.driveTrain[1].inverted);
		m_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, Robot.map.driveTrain[2].inverted);
		m_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, Robot.map.driveTrain[3].inverted);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new mecanumDrive());
    }
    public void mecanumDrive(double xAxis, double yAxis, double twist){
    	m_robotDrive.mecanumDrive_Cartesian(xAxis, yAxis, twist, 0);
    }
    
    public void tankDrive(double left, double right) {
    	m_robotDrive.tankDrive(left, right);
    }
    
    public void mecanumDriveSafe(double xAxis, double yAxis, double twist) {
    	m_robotDrive.mecanumDrive_Cartesian(powerClip(xAxis), powerClip(yAxis), powerClip(twist), 0);
    }
    
    public void tankDriveSafe(double left, double right) {
    	m_robotDrive.tankDrive(powerClip(left), powerClip(right));
    }
    
    public static double powerClip(double power) {
    	if (power > 1) return 1;
    	if (power < -1) return -1;
    	return power;
    }
    
    public void set_base(double base_) {
    	base = base_;
    }
    
    public double get_base() {
    	return base;
    }
}

