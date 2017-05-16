package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.commands.autonomous.AutonomousWaitLeg;
import org.usfirst.frc.team5892.robot.commands.autonomous.ReportYDifference;
import org.usfirst.frc.team5892.robot.commands.autonomous.VisionSequence;
import org.usfirst.frc.team5892.robot.commands.pid.boiler.BoilerVisionPIDCommand;

public class VisionRegShootSequence extends VisionSequence {
    public VisionRegShootSequence(boolean waitForFlywheel) {
    	addParallel(new BoilerVisionPIDCommand());
    	addParallel(new shooter(0.54));
    	addParallel(new ReportYDifference());
    	//addParallel(new VisionRegShoot());
    	if (waitForFlywheel) addSequential(new AutonomousWaitLeg(6));
    	addSequential(new ActivateFeeder());
    }
}
