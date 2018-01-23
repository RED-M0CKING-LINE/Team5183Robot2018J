// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.Auton;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    
	@Override
	public void robotInit() {
		// Robot-Wide initialization code
		RobotMap.MOTORS_L.enableDeadbandElimination(true);
		RobotMap.MOTORS_R.enableDeadbandElimination(true);
		
		// Auton Selection Configuration
		SendableChooser<Command> chooser = new SendableChooser<>();
        chooser.addObject("Autonomous Command: Left", new AutonomousCommand("left", "", "", ""));
        chooser.addObject("Autonomous Command: Center", new AutonomousCommand("", "center", "", ""));
        chooser.addObject("Autonomous Command: Right", new AutonomousCommand("", "", "right", ""));
        chooser.addObject("Autonomous Command: Default", new AutonomousCommand("", "", "", "default"));
        chooser.addDefault("Autonomous Command", new AutonomousCommand("", "", "", "default"));
        SmartDashboard.putData("Auton mode", chooser);
        
        // Putting buttons in the SmartDashboard
        SmartDashboard.putData("Autonomous Command: Left", new Command("left", "", "", ""));
        SmartDashboard.putData("Autonomous Command: Center", new AutonomousCommand("", "center", "", ""));
        SmartDashboard.putData("Autonomous Command: Right", new AutonomousCommand("", "", "right", ""));
        SmartDashboard.putData("Autonomous Command: Default", new AutonomousCommand("", "", "", "default"));
        SmartDashboard.putData("Test", new Test());
	} //TODO fix this ^^^

	
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
	}

	
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}
// TODO get pneumatics working, setup auton selectiong and make it work, and start default auton
