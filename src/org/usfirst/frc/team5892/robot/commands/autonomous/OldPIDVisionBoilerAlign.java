package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.ActivateFeeder;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

@Deprecated
public class OldPIDVisionBoilerAlign extends PIDCommand {
    
	ITable table;
	static final double CAMERA_X_CENTER = 80;
	
	Victor feeder = ActivateFeeder.feeder;
	
	static final double kP = 0.2;
	static final double kI = 0.1;
	static final double kD = 0.0;
	
	public OldPIDVisionBoilerAlign() {
		super(kP, kI, kD);
		setSetpoint(CAMERA_X_CENTER);
		requires(Robot.drive);
		setInputRange(0, 160);
		this.getPIDController().setOutputRange(-1, 1);
	}
	
	@Override
	protected double returnPIDInput() {
		double input;
		double centerX[] = table.getNumberArray("centerX", new double[]{-2, -2});
	    if (centerX.length > 2) {
	    	double area[] = table.getNumberArray("area", new double[]{-2, -2});
	    	//double ys[] = table.getNumberArray("centerY", new double[]{-2, -2});
	    	double points[] = new double[2];
	    	double maxArea[] = new double[]{-1, -1};
	    	for (int i=0;i<area.length && i<centerX.length/* && i<ys.length*/;i++) {
	    		//if (ys[i] < 90) {
		    		if (area[i] > maxArea[0]) {
		    			maxArea[1] = maxArea[0]; points[1] = points[0];
		    			maxArea[0] = area[i];
		    			points[0] = centerX[i];
		    		} else if (area[i] > maxArea[1]) {
		    			maxArea[1] = area[i]; points[1] = centerX[i];
		    		}
	    		//}
	    	}
	    	input = (points[0] + points[1]) / 2;
	    } else if (centerX.length == 2) {
	    	input = (centerX[0] + centerX[1]) / 2;
	    } else if (centerX.length == 1) {
	    	input = centerX[0];
	    } else {
	    	input = CAMERA_X_CENTER; //cancel();
	    }
	    SmartDashboard.putNumber("PID Input", input);
	    System.out.println("PID Input: " + input);
	    return input;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drive.mecanumDrive(0, 0, output);
        SmartDashboard.putNumber("PID Output", output);
        System.out.println("PID Output: " + output);
	}
	
	@Override
	protected void execute() {
	
		System.out.println("Execute ran");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		System.out.println("IsFinished ran");
		return false;
	}

}
