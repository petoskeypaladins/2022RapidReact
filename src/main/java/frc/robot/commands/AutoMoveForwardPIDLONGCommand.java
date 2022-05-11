// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
 
public class AutoMoveForwardPIDLONGCommand extends CommandBase {
  /** Creates a new AutoPIDForwardCommand. */
  private double goalOne;
  public AutoMoveForwardPIDLONGCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
  }
 
  //REMEMBER THESE:
  //LEFT ENCODER VALUES GO UP WHEN IT SPINS IN THE DIRECTION OF THE INTAKE.
  //RIGHT ENCODER VALUES GO UP WHEN IT SPINS IN THE DIRECTION OF THE LAUNCHER.
 
  public AutoMoveForwardPIDLONGCommand(double a) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
    goalOne = a;
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveSubsystem.leftEncoder.setPosition(0);
    DriveSubsystem.rightEncoder.setPosition(0);
    DriveSubsystem.pidOne.setSetpoint(goalOne);
    DriveSubsystem.rightDrive.setInverted(true);
    DriveSubsystem.pidOne.setP(1/goalOne);
    SmartDashboard.putNumber("P value", 1/goalOne);
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("PID Calculation", DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne));
    SmartDashboard.putNumber("Motor Speed", DriveSubsystem.leftOne.get());
    if (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne) >= 0.25) {
      DriveSubsystem.drive.arcadeDrive(0.45 + (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne)*0.6), 0);
    } else if (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne) >= 0) {
      DriveSubsystem.drive.arcadeDrive(0.3 + (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne) * 1.2), 0);
    } else if (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne) >= -0.25) {
      DriveSubsystem.drive.arcadeDrive(-0.3 + (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne)*1.2), 0);
    } else {
      DriveSubsystem.drive.arcadeDrive(-0.45 + (DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne)*0.6), 0);
    }
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
    return (DriveSubsystem.pidOne.atSetpoint());
  }
}
 
 
 

