package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.commands.mecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/*
	 *     - PWM 3 - Connected to front left drive motor
	 *     - PWM 7 - Connected to rear left drive motor
	 *     - PWM 8 - Connected to front right drive motor
	 *     - PWM 2 - Connected to rear right drive motor
	 */
	RobotDrive m_robotDrive = new RobotDrive(3, 7, 8, 2);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new mecanumDrive());
    }
    public void mecanumDrive(double xAxis, double yAxis, double twist){
    	m_robotDrive.mecanumDrive_Cartesian(xAxis, yAxis, twist,0);
    }
}

