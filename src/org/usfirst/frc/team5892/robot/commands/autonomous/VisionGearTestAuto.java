package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionGearTestAuto extends CommandGroup{
    public VisionGearTestAuto() {
    	addSequential(new VisionGearAlign());
    	addSequential(new AutonomousDriveLeg(0, 0.3, 0, 0.5));
    }
}
