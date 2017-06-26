package org.usfirst.frc.team5892.robot.oi;

public interface Pilot {
    public double xAxis();
    public double yAxis();
    public double twist();
    
    public boolean loSpeed();
    public boolean gearPneum();
}
