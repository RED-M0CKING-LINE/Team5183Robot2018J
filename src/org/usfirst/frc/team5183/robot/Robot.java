// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	public final String defaultAuton = "defaultAuton";
	public final String AutonLeft = "AutonLeft";
	public final String AutonCenter = "AutonCenter";
	public final String AutonRight = "AutonRight";
	public String autonSelected;
	public SendableChooser<String> chooser = new SendableChooser<>();
	
	@Override
	public void robotInit() {
		// Robot-Wide initialization code

		// Autonomous Selection
		chooser.addDefault("Default Auto", defaultAuton);
		chooser.addObject("AutonLeft", AutonLeft);
		chooser.addObject("AutonCenter", AutonCenter);
		chooser.addObject("AutonRight", AutonRight);

		SmartDashboard.putData("Auto choices", chooser);
	}

	
	@Override
	public void autonomousInit() {
		// autoSelected = chooser.getSelected();
		autonSelected = SmartDashboard.getString("Auto Selector", defaultAuton);
		System.out.println("Auto selected: " + autonSelected);
	}

	
	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
		
		String gameData;
	
		switch (autonSelected) {
		case AutonLeft:
			// Auton Left
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if(gameData.charAt(0) == 'L')  // this will check the first character of the game specific data to test for a 'L' or 'R'
			{
				//Put left auton code here
			} else if(gameData.charAt(0) == 'R'){
				//Put right auton code here
			} else {
				//Put default auton code here
			}
			
		case AutonCenter:
			// Auton Center
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if(gameData.charAt(0) == 'L')  // this will check the first character of the game specific data to test for a 'L' or 'R'
			{
				//Put left auton code here
			} else if(gameData.charAt(0) == 'R'){
				//Put right auton code here
			} else {
				//Put default auton code here
			}
			
		case AutonRight:
			// Auton Right
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if(gameData.charAt(0) == 'L')  // this will check the first character of the game specific data to test for a 'L' or 'R'
			{
				//Put left auton code here
			} else if(gameData.charAt(0) == 'R'){
				//Put right auton code here
			} else {
				//Put default auton code here
			}

		case defaultAuton:
		default:
			// Put default auto code here
			break;
		}
	}


	@Override
	public void teleopPeriodic() {
		// called periodically during operator control
		RobotMap.drive.mecanumDrive_Cartesian(RobotMap.m_driveStick.getX(), RobotMap.m_driveStick.getY(), RobotMap.m_driveStick.getTwist(),0);
	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}

