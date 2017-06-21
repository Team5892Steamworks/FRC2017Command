package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class InlineTrigger extends Trigger {
    ITriggerGetter getter;
	
    public InlineTrigger(ITriggerGetter getter) {
    	this.getter = getter;
    }
	
	@Override
	public boolean get() {
		return getter.get();
	}
    
}
