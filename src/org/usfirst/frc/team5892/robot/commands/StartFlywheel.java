package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

public class StartFlywheel extends Command {
    
	static Victor flywheel = shooter.flywheel;
	
	@Override
	protected void initialize() {
		flywheel.set(-1);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
