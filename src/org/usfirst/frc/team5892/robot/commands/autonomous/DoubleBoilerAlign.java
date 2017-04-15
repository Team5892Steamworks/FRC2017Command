package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoubleBoilerAlign extends CommandGroup{
    public DoubleBoilerAlign() {
    	addSequential(new VisionBoilerAlign());
    	addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new VisionBoilerAlign());
    }
}
