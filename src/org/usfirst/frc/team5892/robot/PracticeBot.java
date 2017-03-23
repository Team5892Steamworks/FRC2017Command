package org.usfirst.frc.team5892.robot;

public class PracticeBot extends RobotMapA {
    public PracticeBot() {
    	driveTrain = new int[]{2, // front left
    			               8, // rear left
    			               3, // front right
    			               7};// rear right
    	agitator = 0;
    	intake = 9;
    	flywheel = 1;
    	feeder = 4;
    	winch = 5;
    }
}
