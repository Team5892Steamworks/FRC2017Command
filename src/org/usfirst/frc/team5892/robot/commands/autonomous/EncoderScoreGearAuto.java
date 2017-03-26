package org.usfirst.frc.team5892.robot.commands.autonomous;



public class EncoderScoreGearAuto extends EncoderAuto {
    public EncoderScoreGearAuto(boolean goForHopper, Position position) {
    	double dir = position == Position.RIGHT ? 1 : -1;
    	
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, distToBaseline + linearInch(22)));
    	addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.4, 82));
    	//addSequential(new VisionGearAlign());
    	addSequential(new EncoderAutonomousDriveLeg(0, 0.2, 0, linearInch(24)));
    	
    	if (goForHopper) {
    		addSequential(new AutonomousWaitLeg(7));
    		addSequential(new EncoderAutonomousDriveLeg(0, -.2, 0, linearInch(40)));
    		//addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*0.3, ))
    	}
    }
    /*
     * 3/25 - 20, 75, 24 worked
     * 3/26 - 22, 82, 24 worked
     */
}
