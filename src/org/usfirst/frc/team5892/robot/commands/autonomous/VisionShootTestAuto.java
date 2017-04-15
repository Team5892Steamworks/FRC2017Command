package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.ActivateFeeder;
import org.usfirst.frc.team5892.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionShootTestAuto extends CommandGroup {
    public VisionShootTestAuto() {
    	addParallel(new shooter());
    	addSequential(new AutonomousWaitLeg(6));
    	addSequential(new DoubleBoilerAlign());
    	addSequential(new AutonomousWaitLeg(.5));
    	addSequential(new ActivateFeeder());
    }
}
