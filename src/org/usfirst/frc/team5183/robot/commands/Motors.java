/**
 * 
 */
package org.usfirst.frc.team5183.robot.commands;

import org.usfirst.frc.team5183.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;

public class Motors {
	/*
	 * this command class is designed for commands for using the motors.
	 * these commands are for drive train movement only.
	 */
	
	public void move(double left, double right, double time) {
		/* this is  command used to move the robot on a timer
		 * @param left - sets to move the left side motors
		 * @param right - sets to move the right side motors
		 * @param time - sets amount of wait time in seconds
		 */
		
		RobotMap.MOTORS_L.set(left);
		RobotMap.MOTORS_R.set(right);
		
		Timer.delay(time);
		
		stop();
	}
	
	public void turnC(double speed, double angle, String clock) {
		/* this command is for turning the robot. 
		 * @param speed - how fast the robot should move
		 * @param angle - what angle the robot should stop at
		 * @param clock - "c" or "cc". 'c' for clockwise or 'cc' for counter-clockwise
		 */
		
		if(clock == "c") {
			RobotMap.MOTORS_L.set(speed);
			RobotMap.MOTORS_R.set(-speed);
		}else if(clock == "cc") {
			RobotMap.MOTORS_L.set(-speed);
			RobotMap.MOTORS_R.set(speed);
		}else { //DEFAULT CLOCKWISE
			RobotMap.MOTORS_L.set(speed);
			RobotMap.MOTORS_R.set(-speed);
		}
	}
	private void stop() {
		/* this is to stop the robot in its tracks */
		RobotMap.MOTORS_L.set(0);
		RobotMap.MOTORS_R.set(0);
	}
}
