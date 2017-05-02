package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PartyAuto extends CommandGroup {
    public PartyAuto() {
    	addParallel(new AutonomousDriveLeg(0, 0, 0.6, 1000));
    	addParallel(new shooter(1));
    	addSequential(new AutonomousWaitLeg(5));
    	addSequential(new ActivateFeeder());
    	addSequential(new AutonomousWaitLeg(955));
    }
}
