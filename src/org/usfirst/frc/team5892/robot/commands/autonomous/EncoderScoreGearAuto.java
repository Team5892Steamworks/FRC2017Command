package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.EncoderShoot;

public class EncoderScoreGearAuto extends EncoderAuto {
    public EncoderScoreGearAuto(boolean goForHopper, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;

    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, distToBaseline + linearInch(22))); // Move forwards
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 82));                          // Turn
    	//addSequential(new VisionGearAlign());                                                   // Align      
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, linearInch(24), 3));               // Move onto spike
    	
    	if (goForHopper) {
    		addSequential(new EncoderAutonomousDriveLeg(0, -.3, 0, linearInch(30)));              // Move off of spike
    		addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*-.4, 180));                     // Turn towards hopper
    		addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, linearInch(95)));              // Move towards hopper
    		addSequential(new EncoderAutonomousDriveLeg(-.8, 0, 0, 500));                                  // Activate hopper
    		addSequential(new AutonomousWaitLeg(2));
    		addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 7.5));                      // Align with boiler
    		addSequential(new EncoderShoot(40000));                                                // Open fire
    	}
    }
    /*
     * 3/25 - 20, 75, 24 worked
     * 3/26 - 22, 82, 24 worked
     */
}
