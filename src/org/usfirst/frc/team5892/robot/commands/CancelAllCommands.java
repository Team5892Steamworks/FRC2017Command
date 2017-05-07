package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class CancelAllCommands extends Command {
    
	@Override
	protected void initialize() {
		Scheduler.getInstance().removeAll();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
