// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
 
public class AutoMoveForwardSlowDownCommand extends CommandBase {
  /** Creates a new AutoMoveForwardCommand. */
  private int FinalEncoderValue;
  private double RobotSpeed;
 
  public AutoMoveForwardSlowDownCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
  }
  public AutoMoveForwardSlowDownCommand(int Encoder, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
    FinalEncoderValue = Encoder;
    RobotSpeed = speed;
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveSubsystem.rightDrive.setInverted(true);
    DriveSubsystem.leftEncoder.setPosition(0);
    DriveSubsystem.rightEncoder.setPosition(0);
    DriveSubsystem.leftOne.getEncoder();
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.leftDrive.set(RobotSpeed * (1 - (DriveSubsystem.leftEncoder.getPosition()/(2*FinalEncoderValue))));
    DriveSubsystem.rightDrive.set(RobotSpeed * (1 - (DriveSubsystem.leftEncoder.getPosition()/(3*FinalEncoderValue))));
  }
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.leftDrive.set(0);
    DriveSubsystem.rightDrive.set(0);
    DriveSubsystem.leftEncoder.setPosition(0);
    DriveSubsystem.rightEncoder.setPosition(0);
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (DriveSubsystem.leftEncoder.getPosition() >= FinalEncoderValue);
  }
}
 
 
 

