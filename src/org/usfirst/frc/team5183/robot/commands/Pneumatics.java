package org.usfirst.frc.team5183.robot.commands;

import org.usfirst.frc.team5183.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;


public class Pneumatics extends Subsystem {
	
	//public DoubleSolenoid piston1 = RobotMap.piston1;
	// public DoubleSolenoid piston2 = RobotMap.piston2;
	
	public void start() { // starts all the pneumatic systems
		//c.setClosedLoopControl(true);
	} 
	
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    @Override
    public void initDefaultCommand() {
    }
    
    @Override
    public void periodic() {
    	//c.setClosedLoopControl(true);
    }
}
