package org.usfirst.frc.team5183.robot;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
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
	public final static XboxController m_ctrl = new XboxController(0); //Xbox Controller on port 0 of the DS
	// Axis raw numbers
	public static final int L_X_AXIS = 0;
	public static final int L_Y_AXIS = 1;
	public static final int L_TRIG = 2;
	public static final int R_TRIG = 3;
	public static final int R_X_AXIS = 4;
	public static final int R_Y_AXIS = 5;
	
	
	// Robot Driving Config
	public final static MecanumDrive drive = new MecanumDrive(MOTOR_RR, MOTOR_FR, MOTOR_FL, MOTOR_RL); //Motor order for the robot drive class
	//NOTE USE drivePolar FOR AUTON
	public final static double AUTON_MAX_SPEED_F = 0.5; // Max auton speed forward
	public final static double AUTON_MAX_SPEED_R = -0.5; // Max auton speed backwards
	
	
	// Measurements - USE THESE FOR FINE TUNING THE ROBOT AND HAVE MOVEMENT PERSISTANCE
	public final static double WHEEL_SIZE = 5;  // Measured in Centimeters
}
