package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.*;
import org.usfirst.frc.team5892.robot.commands.pid.boiler.HEROicBoilerAlignCommand;

public class EncoderScoreGearAuto extends EncoderAuto {
    public EncoderScoreGearAuto(boolean shoot, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;
    	
    	if (shoot) addParallel(new shooter(0.7));                                              // Start up flywheel
    	
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, 666));                             // Move forwards
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 300));                         // Turn
    	//addSequential(new HEROicGearAlignCommand());                                            // Align      
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, 75, 3));               // Move onto spike
    	addSequential(new PushGear(true));                                                        // ACTIVE GEAR MECHANISM
    	
    	if (shoot) {                                                                              // If trying to shoot:
    		addSequential(new EncoderAutonomousDriveLeg(0, -0.3, 0, 200));             // Move off of spike
    		addParallel(new HEROicBoilerAlignCommand());                                          // Align
    		addParallel(new ActivateFeeder());                                                    // And...
    		//addSequential(new UltrasonicShoot());                                               // Shoot!!! (except we're already shooting)
    	}
    }
    /*
     * 3/25 - 20, 75, 24 worked
     * 3/26 - 22, 82, 24 worked
     */
}
