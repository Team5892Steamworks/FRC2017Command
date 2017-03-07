package org.usfirst.frc.team5892.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class POVTrigger extends Trigger {
	
	Joystick joystick;
	int angle;
	
	public POVTrigger(Joystick joystick_, int angle_) {
		joystick = joystick_;
		angle = angle_;
	}

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return joystick.getPOV(0) == angle;
	}

}
