package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.commands.AccelerometerUpdate;

import edu.wpi.first.wpilibj.command.Subsystem;



public class Accelerometer extends Subsystem {
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new AccelerometerUpdate());
    }
}

