package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.PushGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** It's the end. */
public class TheFinalAuto extends CommandGroup {
	public TheFinalAuto() {
		addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, 650));
		addSequential(new PushGear(true));
	}
}
