package org.usfirst.frc.team5892.robot;

public class PracticeBot extends RobotMapB {
    public PracticeBot() {
    	driveTrain = new MotorMap[]{new MotorMap(8, true),  // front left
    			                    new MotorMap(3, true),   // rear left
    			                    new MotorMap(7, false),   // front right
    			                    new MotorMap(2, false)}; // rear right
    	controlSetup = new ControlSetup[]{ControlSetup.xAxis, ControlSetup.yAxis, ControlSetup.twist};
    	agitator = new MotorMap(0, false);
    	intake = new MotorMap(9, false);
    	flywheel = new MotorMap(1, false);
    	feeder = new MotorMap(4, true);
    	winch = new MotorMap(5, false);
    	encoderLeft = 1;
    	encoderRight = 2;
    }
}
