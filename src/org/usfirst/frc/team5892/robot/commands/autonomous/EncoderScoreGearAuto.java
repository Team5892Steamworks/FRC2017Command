package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.shooter;

public class EncoderScoreGearAuto extends EncoderAuto {
    public EncoderScoreGearAuto(boolean shoot, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;
    	
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, distToBaseline + linearInch(17))); // Move forwards
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 80));                          // Turn
    	//addSequential(new VisionGearAlign());                                                   // Align      
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, linearInch(24), 3));               // Move onto spike
    	
    	if (shoot) {                                                                              // If trying to shoot:
    		addSequential(new EncoderAutonomousDriveLeg(0, -0.3, 0, linearInch(60)));             // Move off of spike
    		addSequential(new shooter());
    	}
    }
    /*
     * 3/25 - 20, 75, 24 worked
     * 3/26 - 22, 82, 24 worked
     */
}
