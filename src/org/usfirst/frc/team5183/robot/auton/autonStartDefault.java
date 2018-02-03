package org.usfirst.frc.team5183.robot.auton;

import org.usfirst.frc.team5183.robot.commands.*;
import org.usfirst.frc.team5183.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autonStartDefault extends Command {

    public autonStartDefault() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Motors M = new Motors();
    	M.move(RobotMap.AUTON_MAX_SPEED_F, RobotMap.AUTON_MAX_SPEED_F, 5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
