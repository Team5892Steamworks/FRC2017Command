package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

public class EncoderScoreGearAutoX extends EncoderAuto {
	
    @Override
    protected void initialize() {
        double dir = Robot.posChooser.getSelected() == Position.RIGHT ? 1 : -1;
    	
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, distToBaseline + linearInch(17))); // Move forwards
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 80));                          // Turn
    	//addSequential(new VisionGearAlign());                                                   // Align      
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, linearInch(24), 3));               // Move onto spike
    	
    	addSequential(Robot.afterChooser.getSelected());
    }
}
