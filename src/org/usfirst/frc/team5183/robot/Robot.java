// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.Auton;

import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		// Robot-Wide initialization code
		RobotMap.MOTOR_FL.enableDeadbandElimination(true);
		RobotMap.MOTOR_FR.enableDeadbandElimination(true);
		RobotMap.MOTOR_RL.enableDeadbandElimination(true);
		RobotMap.MOTOR_RR.enableDeadbandElimination(true);
	}

	
	@Override
	public void autonomousInit() {
		// autonomous initialization code
		
	}

	
	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
	}


	@Override
	public void teleopPeriodic() {
		// called periodically during operator control
		RobotMap.DRIVE.tankDrive(RobotMap.L_Y_AXIS, RobotMap.R_Y_AXIS, true);
		//TODO add accelerated inputs: 0-2-4-8-16-32-64-[cap limit]
		//TODO CHANGE THIS SHIT TO TANK DRIVE BEOCH
	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}

