package org.usfirst.frc.team5892.robot.commands.autonomous;

public class EncoderDriveStraightAuto extends EncoderAuto {
    public EncoderDriveStraightAuto() {
    	addSequential(new EncoderAutoDriveStraight(0.3, distToBaseline));
    }
}
