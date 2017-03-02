package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardsAndSpinAuto extends CommandGroup {
    public DriveForwardsAndSpinAuto() {
    	addSequential(new AutonomousDriveLeg(0, 1, 0, 3));
    	addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new AutonomousDriveLeg(0, 0, 1, 3));
    }
}