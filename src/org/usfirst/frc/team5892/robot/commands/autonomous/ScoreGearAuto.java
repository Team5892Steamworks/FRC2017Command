package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

@WorkInProgress
public class ScoreGearAuto extends CommandGroup {
    public ScoreGearAuto() {
    	addSequential(new AutonomousDriveLeg(0, 0.7, 0, 1.5));
    	addSequential(new AutonomousDriveLeg(0, 0, -0.3, 2));
    	addSequential(new AutonomousDriveLeg(0, 0.7, 0, 0.5));
    }
}
