package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;

public abstract class Controller {
    protected Joystick stick;
    
    public Controller(int port) {
    	stick = new Joystick(port);
    }
}
