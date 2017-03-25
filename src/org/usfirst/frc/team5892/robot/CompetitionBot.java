package org.usfirst.frc.team5892.robot;

public class CompetitionBot extends RobotMapB {
    public CompetitionBot() {
    	driveTrain = new MotorMap[]{new MotorMap(3, false), new MotorMap(7, false), 
    			                    new MotorMap(8, false), new MotorMap(2, false)}; // <== FINAL. DO NOT CHANGE EVER. (unless they rewire the robot in which case: D:)
    	controlSetup = new ControlSetup[]{ControlSetup.xAxis, ControlSetup.twist, ControlSetup.yAxis};
    	agitator = new MotorMap(0, false);
    	intake = new MotorMap(9, false);
    	flywheel = new MotorMap(1, false);
    	feeder = new MotorMap(4, false);
    	winch = new MotorMap(5, false);
    }
}
