package org.usfirst.frc.team5183.robot.commands;

import org.usfirst.frc.team5183.robot.RobotMap;
// import org.usfirst.frc.team5183.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton {
	/*
	 * This class contains all Auton Conditions
	 */
	
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	public int autonStartLeft() {
		return 99;
	}
	
	public int autonStartCenter() {
		return 99;
	}
	
	public int autonStartRight() {
		return 99;
	}
	
	public int autonStartDefault() {
		Motors M = new Motors();
    	M.move(RobotMap.AUTON_MAX_SPEED_F, RobotMap.AUTON_MAX_SPEED_F, 5);
		return 99;
	}
	
	

	
}
