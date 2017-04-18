package org.usfirst.frc.team5892.robot.commands.autonomous;

public class DoubleBoilerAlign extends VisionSequence {
    public DoubleBoilerAlign() {
    	addSequential(new VisionBoilerAlign());
    	addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new VisionBoilerAlign());
    }
}
