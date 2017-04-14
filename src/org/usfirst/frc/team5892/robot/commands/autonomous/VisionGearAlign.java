package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.pixy.*;

/**
 *
 */
public class VisionGearAlign extends Command {
	static Pixy pixy;
	static final double CAMERA_X_CENTER = 80;
	static final double TOLERANCE = 5;
	static final double ROTATE_SPEED = .6;

	double cpoint = CAMERA_X_CENTER;

	public VisionGearAlign() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		pixy = new Pixy();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		/*
		 * double centerX[] = table.getNumberArray("centerX", new double[]{-2,
		 * -2}); if (centerX.length > 2) { double area[] =
		 * table.getNumberArray("area", new double[]{-2, -2}); //double ys[] =
		 * table.getNumberArray("centerY", new double[]{-2, -2}); double
		 * points[] = new double[2]; double maxArea[] = new double[]{-1, -1};
		 * for (int i=0;i<area.length && i<centerX.length && i<ys.length;i++) {
		 * //if (ys[i] < 90) { if (area[i] > maxArea[0]) { maxArea[1] =
		 * maxArea[0]; points[1] = points[0]; maxArea[0] = area[i]; points[0] =
		 * centerX[i]; } else if (area[i] > maxArea[1]) { maxArea[1] = area[i];
		 * points[1] = centerX[i]; } //} } cpoint = (points[0] + points[1]) / 2;
		 * } else if (centerX.length == 2) { cpoint = (centerX[0] + centerX[1])
		 * / 2; } else if (centerX.length == 1) { cpoint = centerX[0]; } else {
		 * cancel(); }
		 */
		// double cpoint = (centerX[0] + centerX[1]) / 2;

		PixyPacket[] stuff = new PixyPacket[0];
		boolean cont = false;
		try {
			stuff = new PixyPacket[] { pixy.readPacket(1), pixy.readPacket(2) };
			cont = true;
		} catch (PixyException e) {
			e.printStackTrace();
			cancel();
		}

		if (cont) {

			cpoint = (stuff[0].X + stuff[1].X) / 2;

			if (cpoint < CAMERA_X_CENTER) {
				Robot.drive.mecanumDrive(0, 0, ROTATE_SPEED);
			} else if (cpoint > CAMERA_X_CENTER) {
				Robot.drive.mecanumDrive(0, 0, -ROTATE_SPEED);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (cpoint > CAMERA_X_CENTER - TOLERANCE && cpoint < CAMERA_X_CENTER + TOLERANCE)
				|| Robot.oi.pilot.getRawButton(5);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
