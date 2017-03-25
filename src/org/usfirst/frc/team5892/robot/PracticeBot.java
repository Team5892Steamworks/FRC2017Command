package org.usfirst.frc.team5892.robot;

public class PracticeBot extends RobotMapB {
    public PracticeBot() {
    	driveTrain = new MotorMap[]{new MotorMap(2, false),  // front left
    			                    new MotorMap(8, true),   // rear left
    			                    new MotorMap(3, true),   // front right
    			                    new MotorMap(7, false)}; // rear right
    	controlSetup = new ControlSetup[]{ControlSetup.twist, ControlSetup.xAxis, ControlSetup.yAxis};
    	ControlSetup.twist.setInverted(true);
    	ControlSetup.xAxis.setInverted(true);
    	agitator = new MotorMap(0, false);
    	intake = new MotorMap(9, false);
    	flywheel = new MotorMap(1, false);
    	feeder = new MotorMap(4, false);
    	winch = new MotorMap(5, false);
    }
}
