package org.usfirst.frc.team5892.robot;

public class CompetitionBot extends RobotMapA {
    public CompetitionBot() {
    	driveTrain = new int[]{3, 7, 8, 2}; // <== FINAL. DO NOT CHANGE EVER. (unless they rewire the robot in which case: D:)
    	agitator = 0;
    	intake = 9;
    	flywheel = 1;
    	feeder = 4;
    	winch = 5;
    }
}
