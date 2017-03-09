package org.usfirst.frc.team5892.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class AnalogAxisTrigger extends Trigger {
    Joystick joystick;
    int axis;
    double threshold;
    
    public AnalogAxisTrigger(Joystick joystick_, int axis_) {
    	joystick = joystick_;
    	axis = axis_;
    	threshold = 0.8;
    }
    
    public AnalogAxisTrigger(Joystick joystick_, int axis_, double threshold_) {
    	joystick = joystick_;
    	axis = axis_;
        threshold = threshold_;
    }
    
	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return joystick.getRawAxis(axis) > threshold;
	}

}
