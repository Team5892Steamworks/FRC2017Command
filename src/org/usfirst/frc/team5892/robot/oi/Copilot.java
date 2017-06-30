package org.usfirst.frc.team5892.robot.oi;

public interface Copilot {
    public boolean shooter();
    public boolean shooter_static();
    public boolean feeder();
    public boolean boiler_align();
    
    public boolean winch_fwd();
    public boolean winch_rev();
}
