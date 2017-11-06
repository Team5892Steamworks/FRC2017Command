package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;

// this is stupid, don't use it again next year
public abstract class Controller {
    protected Joystick stick;
    
    public Controller(int port) {
    	stick = new Joystick(port);
    }
}
