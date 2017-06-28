package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.commands.*;

public class OI {
	public Pilot pilot;
	public Copilot copilot;
	
    public OI(Pilot pilot, Copilot copilot) {
    	this.pilot = pilot;
    	this.copilot = copilot;
    	
    	// Pilot commands
    	new InlineTrigger(pilot::gearPneum).whileActive(new PushGear(false));
    	
    	// Copilot commands
    	new InlineTrigger(copilot::shooter).whileActive(new UltrasonicShoot());
    	new InlineTrigger(copilot::shooter_lo).whileActive(new shooter(.5));
    	new InlineTrigger(copilot::feeder).whileActive(new ActivateFeeder());
    	new InlineTrigger(copilot::winch_fwd).whileActive(new ActivateWinch(1));
    	new InlineTrigger(copilot::winch_rev).whileActive(new ActivateWinch(-1));
    }
}
