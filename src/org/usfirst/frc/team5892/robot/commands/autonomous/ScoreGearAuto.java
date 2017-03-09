package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreGearAuto extends CommandGroup {
    public ScoreGearAuto(boolean goForHopper) {
    	addSequential(new AutonomousDriveLeg(0, 0.4, 0, 1.4)); // Move forwards towards gear spike
    	addSequential(new AutonomousDriveLeg(0, 0, 0.3, 0.5));   // Align with gear spike
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, 0.8)); // Push gear onto spike
    	
    	if (goForHopper) {
    	addSequential(new AutonomousWaitLeg(5));               // Wait for human player to take gear
    	addSequential(new AutonomousDriveLeg(0, -.4, 0, 0.5)); // Move away from gear spike
    	addSequential(new AutonomousDriveLeg(0, 0, .3, 0.8)); // Turn away from hopper
    	addSequential(new AutonomousDriveLeg(0, -.4, 0, 1.5));   // Activate hopper
    	}
    	
        /*addSequential(new AutonomousDriveLeg(0, 0, -.3, 0.75));   // Turn forwards
        addSequential(new AutonomousDriveLeg(0, 0.4, 0, 3));   // Move across line
*/    }
    
    /*public void doTheThing() {
    	while (hasBatteries() && seesTable()) moveTowardsTableReallyFast();
    }*/
}
