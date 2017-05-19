package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.pid.gear.HEROicGearAlignCommand;

public class BoringForwardsAuto extends EncoderAuto {
    public BoringForwardsAuto() {
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, 700));
    	addSequential(new AutonomousWaitLeg(1));
    	//addSequential(new HEROicGearAlignCommand(), 10);
    	/*addSequential(new AutonomousWaitLeg(0.5));
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, 150));*/
    	/*addSequential(new AutonomousDriveLeg(0, 0.25, 0, 1));
    	addSequential(new AutonomousDriveLeg(0, 0, .1, .5));
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, .8));*/
    }
}
