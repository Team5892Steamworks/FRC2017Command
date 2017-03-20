package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoringForwardsAuto extends CommandGroup{
    public BoringForwardsAuto() {
    	addSequential(new AutonomousDriveLeg(0, 0.25, 0, 2.1));
    	addSequential(new AutonomousDriveLeg(0, 0.05, 0.05, 5));
    	/*addSequential(new AutonomousDriveLeg(0, 0.25, 0, 1));
    	addSequential(new AutonomousDriveLeg(0, 0, .1, .5));
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, .8));*/
    }
}
