// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    
	Command autonCommand;
	SendableChooser<Command> autonChooser;
	
	@Override
	public void robotInit() {
		// Robot-Wide initialization code
		RobotMap.MOTORS_L.enableDeadbandElimination(true);
		RobotMap.MOTORS_R.enableDeadbandElimination(true);
		
		// Auton Selection Configuration
		autonChooser = new SendableChooser<Command>();
		autonChooser.addDefault("Start Default Auton", ); // default start auton option
		autonChooser.addObject("Start Left Auton", ); // left start auton option
		autonChooser.addObject("Start Center Auton", ); // center start auton option
		autonChooser.addObject("Start Right Auton", ); // right start auton option
		SmartDashboard.putData("Autonomous Mode Chooser", autonChooser);
		//TODO GET THE SELECTION FOR STARTING POSITION FROM THE SMART DASHBOARD AND MAKE IT WORK
	}

	
	@Override
	public void autonomousInit() {
		// autonomous initialization code
		autonCommand = (Command) autonChooser.getSelected();
		autonCommand.start();
	}

	
	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
		Scheduler.getInstance().run();
	}


	@Override
	public void teleopPeriodic() {
		// called periodically during operator control
		RobotMap.DRIVE.arcadeDrive(RobotMap.L_Y_AXIS, RobotMap.R_X_AXIS, true);
	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}
// TODO get pneumatics working, setup auton selection and make it work, and start Auton Configuration
