// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	
	final String defaultAuton = "Default";
	final String AutonB1 = "AutonB1";
	final String AutonB2 = "AutonB2";
	final String AutonB3 = "AutonB3";
	final String AutonR1 = "AutonR1";
	final String AutonR2 = "AutonR2";
	final String AutonR3 = "AutonR3";
	String autonSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	
	Joystick m_driveStick = new Joystick(1); //Joystick on port 1 of the DS

	@Override
	public void robotInit() {
		// Robot-Wide initialization code
		
		/* ###############  START OF ROBOT MAP  ###############
		 * With these values, you are able to configure the robot through the code, such as settings for the robot
		 */ //XXX RobotMap
		
		// These specify the PWM channel each motor is using -- MOTOR_ [left or right] [front or back]
		final int MOTOR_RL = 3; //Rear Left on channel 3
		final int MOTOR_RR = 0; //Rear Right on channel 0
		final int MOTOR_FL = 2; //Front Left on channel 2
		final int MOTOR_FR = 1; //Ront Right on channel 1
		
		// Controller Interfaces
		Joystick m_driveStick = new Joystick(1); //Joystick on port 1 of the DS
		XboxController m_ctrl = new XboxController(1); //Xbox Controller on port 1 of the DS
		
		// Robot Driving Class
		RobotDrive m_robotDrive = new RobotDrive(MOTOR_RR, MOTOR_FR, MOTOR_FL, MOTOR_RL);
		
		/* ###############  END OF ROBOT MAP ############### */
		
		chooser.addDefault("Default Auto", defaultAuton);
		chooser.addObject("AutonB1", AutonB1);
		chooser.addObject("AutonB2", AutonB2);
		chooser.addObject("AutonB3", AutonB3);
		chooser.addObject("AutonR1", AutonR1);
		chooser.addObject("AutonR2", AutonR2);
		chooser.addObject("AutonR3", AutonR3);
		SmartDashboard.putData("Auto choices", chooser);
		
		RobotDrive m_robotDrive = new RobotDrive(MOTOR_RR, MOTOR_FR, MOTOR_FL, MOTOR_RL);
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
		m_robotDrive.mecanumDrive_Cartesian(m_driveStick.getX(), m_driveStick.getY(), m_driveStick.getTwist(),0);

	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}

