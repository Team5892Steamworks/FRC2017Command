package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.commands.autonomous.AutonomousWaitLeg;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class MultRumble extends CommandGroup {
    public MultRumble(int num) {
    	for (int i=0;i<num;i++) {
    		addSequential(new RumbleController(0.2));
    		addSequential(new AutonomousWaitLeg(0.2));
    	}
    }
}
