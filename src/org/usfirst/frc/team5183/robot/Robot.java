// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.Auton;

import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		// Robot-Wide initialization code
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
		RobotMap.drive.driveCartesian(RobotMap.m_ctrl.getRawAxis(RobotMap.L_X_AXIS), RobotMap.m_ctrl.getRawAxis(RobotMap.L_Y_AXIS), RobotMap.m_ctrl.getRawAxis(RobotMap.R_X_AXIS));
		//TODO add accelerated inputs: 0-2-4-8-16-32-64-[cap limit]
	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}

