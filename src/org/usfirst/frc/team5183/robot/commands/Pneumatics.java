package org.usfirst.frc.team5183.robot.commands;

import org.usfirst.frc.team5183.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;


public class Pneumatics {
	
	public Compressor c = new Compressor(0);
	
	boolean enabled = c.enabled();
	boolean pressureSwitch = c.getPressureSwitchValue();
	double current = c.getCompressorCurrent();
	
	public void start() { // starts all the pneumatic systems
		c.setClosedLoopControl(true);
		
	} 
}
