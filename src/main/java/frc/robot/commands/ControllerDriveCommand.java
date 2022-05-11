// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
 
public class ControllerDriveCommand extends CommandBase {
  /** Creates a new ControllerDriveCommand. */
  public ControllerDriveCommand () {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
  }
  public double isTurned = 0.5;
  public double mod = 2;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveSubsystem.rightDrive.setInverted(true);
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_xboxController.getAButtonPressed()) {
      isTurned = isTurned * -1;
    }
    if (RobotContainer.m_xboxController.getBButtonPressed()) {
      mod = 1.25;
    }
    if (RobotContainer.m_xboxController.getYButtonPressed()) {
      mod = 2;
    }
    //DriveSubsystem.drive.arcadeDrive(RobotContainer.m_xboxController.getLeftY(), RobotContainer.m_xboxController.getRightX());
    DriveSubsystem.drive.arcadeDrive(RobotContainer.m_xboxController.getLeftY()*0.8*isTurned*mod, RobotContainer.m_xboxController.getRightX()*0.7*mod);
  }
 
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
 
 
 

