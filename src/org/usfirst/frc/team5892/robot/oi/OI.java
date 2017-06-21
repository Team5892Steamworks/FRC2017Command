package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.commands.ActivateFeeder;
import org.usfirst.frc.team5892.robot.commands.ActivateWinch;
import org.usfirst.frc.team5892.robot.commands.UltrasonicShoot;

public class OI {
	public Pilot pilot;
	public Copilot copilot;
	
    public OI(Pilot pilot, Copilot copilot) {
    	this.pilot = pilot;
    	this.copilot = copilot;
    	
    	// Pilot commands
    	
    	// Copilot commands
    	new InlineTrigger(copilot::shooter).whileActive(new UltrasonicShoot());
    	new InlineTrigger(copilot::feeder).whileActive(new ActivateFeeder());
    	new InlineTrigger(copilot::winch_fwd).whileActive(new ActivateWinch(1));
    	new InlineTrigger(copilot::winch_rev).whileActive(new ActivateWinch(-1));
    }
}
