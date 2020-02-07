/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private PWMVictorSPX leftFM = new PWMVictorSPX(RobotMap.frontLeft);
  private PWMVictorSPX leftBM = new PWMVictorSPX(RobotMap.frontRight);
  private PWMVictorSPX rightBM = new PWMVictorSPX(RobotMap.backRight);
  private PWMVictorSPX rightFM = new PWMVictorSPX(RobotMap.backLeft);

  SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFM, leftBM);
  SpeedControllerGroup rightSide = new SpeedControllerGroup(rightBM, rightFM);

  DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

  public void teleopDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
