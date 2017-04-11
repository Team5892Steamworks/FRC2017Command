package org.usfirst.frc.team5892.robot.triggers;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class MatchTimeTrigger extends Trigger {
    
	final double trip;
	
	public MatchTimeTrigger(double trip) {
		this.trip = trip;
	}
	
	@Override
	public boolean get() {
		return DriverStation.getInstance().getMatchTime() < trip;
	}

}
