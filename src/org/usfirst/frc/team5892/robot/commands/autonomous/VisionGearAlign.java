package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.PrintSomething;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionGearAlign extends CommandGroup {
    public VisionGearAlign() {
    	addSequential(new PrintSomething("Strafe 1"));
    	addSequential(new VisionGearAlignStrafe());
    	
    	addSequential(new PrintSomething("Rotate 1"));
    	addSequential(new VisionGearAlignRotate());
    	
    	addSequential(new PrintSomething("Strafe 2"));
    	addSequential(new VisionGearAlignStrafe());
    	
    	addSequential(new PrintSomething("Rotate 2"));
    	addSequential(new VisionGearAlignRotate());
    	
    	addSequential(new PrintSomething("Done"));
    }
}
