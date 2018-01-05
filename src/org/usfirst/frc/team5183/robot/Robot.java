// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	public final String defaultAuton = "Default";
	public final String AutonB1 = "AutonB1";
	public final String AutonB2 = "AutonB2";
	public final String AutonB3 = "AutonB3";
	public final String AutonR1 = "AutonR1";
	public final String AutonR2 = "AutonR2";
	public final String AutonR3 = "AutonR3";
	public String autonSelected;
	public SendableChooser<String> chooser = new SendableChooser<>();
	
	@Override
	public void robotInit() {
		// Robot-Wide initialization code

		// Autonomous Selection
		chooser.addDefault("Default Auto", defaultAuton);
		chooser.addObject("AutonB1", AutonB1);
		chooser.addObject("AutonB2", AutonB2);
		chooser.addObject("AutonB3", AutonB3);
		chooser.addObject("AutonR1", AutonR1);
		chooser.addObject("AutonR2", AutonR2);
		chooser.addObject("AutonR3", AutonR3);
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
		
		switch (autonSelected) {
		case AutonB1:
			// Auton Left Blue
			break;
			
		case AutonB2:
			// Auton Center Blue
			break;
			
		case AutonB3:
			// Auton Right Blue
			break;
			
		case AutonR1:
			// Auton Left Red
			break;
			
		case AutonR2:
			// Auton Center Red
			break;
			
		case AutonR3:
			// Auton Right Red
			break;
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

