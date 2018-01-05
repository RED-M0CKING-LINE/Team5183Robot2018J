package org.usfirst.frc.team5183.robot;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;

public class RobotMap {
	/* 
	 * With these values, you are able to configure the robot through the code, such as settings for the robot
	 * //NOTE Left Side Motors Inverted Manually Through PWM On Spark (put it in backwards)
	 */

	// These specify the PWM channel each motor is using -- MOTOR_ [left or right] [front or back]
	public final static Spark MOTOR_RL = new Spark(3); //Rear Left on channel 3
	public final static Spark MOTOR_RR = new Spark(0); //Rear Right on channel 0
	public final static Spark MOTOR_FL = new Spark(2); //Front Left on channel 2
	public final static Spark MOTOR_FR = new Spark(1); //Front Right on channel 1
	
	// Controller Interfaces
	public final static Joystick m_driveStick = new Joystick(1); //Joystick on port 1 of the DS
	public final static XboxController m_ctrl = new XboxController(1); //Xbox Controller on port 1 of the DS
	
	// Robot Driving Config
	public final static RobotDrive drive = new RobotDrive(MOTOR_RR, MOTOR_FR, MOTOR_FL, MOTOR_RL); //Motor order for the robot drive class

}
