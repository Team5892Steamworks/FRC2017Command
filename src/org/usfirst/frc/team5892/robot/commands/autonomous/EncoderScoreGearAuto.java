package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.ActivateFeeder;
import org.usfirst.frc.team5892.robot.commands.UltrasonicShoot;
import org.usfirst.frc.team5892.robot.commands.StartFlywheel;

public class EncoderScoreGearAuto extends EncoderAuto {
    public EncoderScoreGearAuto(boolean shoot, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;
    	
    	if (shoot) addParallel(new StartFlywheel());                                              // Start up flywheel
    	
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, distToBaseline + linearInch(22))); // Move forwards
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 300));                // Turn
    	//addSequential(new HEROicGearAlignCommand());                                              // Align      
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, linearInch(24), 3));               // Move onto spike
    	
    	if (shoot) {                                                                              // If trying to shoot:
    		addSequential(new AutonomousWaitLeg(4));                                              // Wait for pilot
    		addSequential(new EncoderAutonomousDriveLeg(0, -0.3, 0, linearInch(60)));             // Move off of spike
    		addParallel(new ActivateFeeder());                                                    // And...
    		addSequential(new UltrasonicShoot());                                                 // Shoot!!!
    	}
    }
    /*
     * 3/25 - 20, 75, 24 worked
     * 3/26 - 22, 82, 24 worked
     */
}
