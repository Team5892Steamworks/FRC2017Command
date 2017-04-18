package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class VisionSequence extends CommandGroup {
	
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.pilot.getRawButton(5);
    }
}
