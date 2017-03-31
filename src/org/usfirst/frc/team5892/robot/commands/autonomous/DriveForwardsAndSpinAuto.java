package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardsAndSpinAuto extends CommandGroup {
    public DriveForwardsAndSpinAuto() {
    	addSequential(new AutonomousDriveLeg(0.3, 0, 0, 3)); // Strafe
    	addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new AutonomousDriveLeg(0, 0.3, 0, 3)); // Forwards
    	addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new AutonomousDriveLeg(0, 0, 0.3, 3)); // Turn
    }
}