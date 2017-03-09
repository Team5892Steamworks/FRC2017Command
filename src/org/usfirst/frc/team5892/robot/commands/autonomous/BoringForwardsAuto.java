package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoringForwardsAuto extends CommandGroup{
    public BoringForwardsAuto() {
    	addSequential(new AutonomousDriveLeg(0, 0.4, 0, 1.5));
    }
}
