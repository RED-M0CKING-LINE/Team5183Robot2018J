package org.usfirst.frc.team5183.robot.auton;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton extends Robot{
	/*
	 * This class contains all Auton Conditions
	 */
	
	boolean autonFinished = false;
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	public boolean autonStartLeft() {
		return true;
	}
	
	public boolean autonStartCenter() {
		return true;
	}
	
	public boolean autonStartRight() {
		return true;
	}
	
	

	
}
