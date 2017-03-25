package org.usfirst.frc.team5892.robot.commands.autonomous;

public class MeasureEncodersAuto extends EncoderAuto {
    public MeasureEncodersAuto() {
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, 0, 1000));
    }
}
