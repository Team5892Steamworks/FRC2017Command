package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreGearAuto extends CommandGroup {
    public ScoreGearAuto(boolean goForHopper, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;
    	
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, 3));       // Move forwards towards gear spike
    	addSequential(new AutonomousDriveLeg(0, 0, dir*0.3, 0.8));   // Align with gear spike
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, 3));         // Push gear onto spike
    	
    	if (goForHopper) {
    	addSequential(new AutonomousWaitLeg(7));                     // Wait for human player to take gear
    	addSequential(new AutonomousDriveLeg(0, -.4, 0, 0.5));       // Move away from gear spike
    	addSequential(new AutonomousDriveLeg(0, 0, dir*0.3, 0.9));   // Turn away from hopper
    	addSequential(new AutonomousDriveLeg(0, -.4, 0, 1.5));       // Activate hopper
    	}
    	
        /*addSequential(new AutonomousDriveLeg(0, 0, -.3, 0.75));   // Turn forwards
        addSequential(new AutonomousDriveLeg(0, 0.4, 0, 3));   // Move across line
*/    }
    
    public enum Position {
    	LEFT,
    	RIGHT;
    }
    /*public void doTheThing() {
    	while (hasBatteries() && seesTable()) moveTowardsTableReallyFast();
    }*/
}
