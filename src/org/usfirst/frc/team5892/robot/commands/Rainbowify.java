package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rainbowify extends Command {
    
	public Rainbowify() {}
	public Rainbowify(double duration) { setTimeout(duration); }
	
	@Override
	protected void initialize() {
		Robot.lights.setRainbow(true);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.lights.setRainbow(false);
	}

}
