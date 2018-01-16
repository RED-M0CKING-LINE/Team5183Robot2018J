package org.usfirst.frc.team5183.robot.auton;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Auton extends IterativeRobot{
	/*
	 * This class contains all Auton Conditions
	 */
	
	public void autonInit() {
		// these are what we will type in for the according auton
		final String defaultAuton = "default";
		final String AutonLeft = "Left";
		final String AutonCenter = "Center";
		final String AutonRight = "Right";
		
		SendableChooser<String> chooser = new SendableChooser<>();
		// autoSelected = chooser.getSelected();
		String autonSelected = SmartDashboard.getString("Auto Selector", defaultAuton);
		System.out.println("Auto selected: " + autonSelected);
		
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if(autonSelected == AutonLeft) {
			//left side start auton
			if(gameData.charAt(0) == 'R') {
				// drive forwards to a position for defense or make way to left side
			}else if(gameData.charAt(0) == 'L') {
				// goes to left side switch and attempts to place block
				
			}else {
				// Default Auton based off starting position
			}
			
		}else if(autonSelected == AutonCenter) {
			// center start auton
			if(gameData.charAt(1) == 'R') {
				// goes to right side switch and attempts to place block
			}else if(gameData.charAt(1) == 'L') {
				// goes to left side switch and attempts to place block
				
			}else {
				// Default Auton based off starting position
			}
			
		}else if(autonSelected == AutonRight) {
			// right side start auton
			if(gameData.charAt(0) == 'R') {
				// goes to right side switch and attempts to place block
			}else if(gameData.charAt(0) == 'L') {
				// drives forwards to a position for defense or make way to left side
				
			}else {
				// Default Auton based off starting position
			}
			
		}else {
			// Default [Drive 12FT stright]
			
		}
	}
}
