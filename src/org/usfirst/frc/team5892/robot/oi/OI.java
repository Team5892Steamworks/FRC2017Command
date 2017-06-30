package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.commands.*;
import org.usfirst.frc.team5892.robot.commands.pid.boiler.HEROicBoilerAlignCommand;

public class OI {
	public Pilot pilot;
	public Copilot copilot;
	
    public OI(Pilot pilot, Copilot copilot) {
    	this.pilot = pilot;
    	this.copilot = copilot;
    	
    	// Pilot commands
    	new InlineTrigger(pilot::gearPneum).whileActive(new PushGear(false));
    	new InlineTrigger(pilot::rainbow).whileActive(new Rainbowify());
    	
    	// Copilot commands
    	new InlineTrigger(copilot::shooter).whileActive(new UltrasonicShoot());
    	new InlineTrigger(copilot::shooter_static).whileActive(new shooter(.5));
    	new InlineTrigger(copilot::feeder).whileActive(new ActivateFeeder());
    	new InlineTrigger(copilot::boiler_align).whileActive(new HEROicBoilerAlignCommand());
    	new InlineTrigger(copilot::winch_fwd).whileActive(new ActivateWinch(1));
    	new InlineTrigger(copilot::winch_rev).whileActive(new ActivateWinch(-1));
    }
}
