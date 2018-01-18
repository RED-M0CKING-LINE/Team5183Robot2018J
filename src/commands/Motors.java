/**
 * 
 */
package commands;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.Robot;
import org.usfirst.frc.team5183.robot.auton.Auton;

public class Motors {
	/*
	 * this command class is designed for commands for using the motors.
	 * these commands are for drive train movement only.
	 */
	
	public void move(double left, double right) {
		/*
		 * @param left - the value to set to move the left side motors
		 * @param right - the value to set to move the right side motors
		 */
		RobotMap.MOTOR_FL.set(left);
		RobotMap.MOTOR_FR.set(right);
		RobotMap.MOTOR_RL.set(left);
		RobotMap.MOTOR_RR.set(right);
	}
	
	public void stop() {
		/*
		 * this is to stop the robot in its tracks
		 */
		RobotMap.MOTOR_FL.set(0);
		RobotMap.MOTOR_FR.set(0);
		RobotMap.MOTOR_RL.set(0);
		RobotMap.MOTOR_RR.set(0);
	}
}
