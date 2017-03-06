package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

@WorkInProgress
public class ScoreGearAuto extends CommandGroup {
    public ScoreGearAuto() {
    	addSequential(new AutonomousDriveLeg(0, 0.7, 0, 1.5)); // Move forwards towards gear spike
    	addSequential(new AutonomousDriveLeg(0, 0, -.3, 2));   // Align with gear spike
    	addSequential(new AutonomousDriveLeg(0, 0.7, 0, 0.5)); // Push gear onto spike
    	addSequential(new AutonomousWaitLeg(3));               // Wait for human player to take gear
    	addSequential(new AutonomousDriveLeg(0, -.7, 0, 0.5)); // Move away from gear spike
        addSequential(new AutonomousDriveLeg(0, 0, 0.3, 2));   // Turn forwards
        addSequential(new AutonomousDriveLeg(0, 0.7, 0, 3));   // Move across line
    }
}
