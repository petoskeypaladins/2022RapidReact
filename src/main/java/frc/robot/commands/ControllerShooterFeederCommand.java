// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ControllerShooterFeederCommand extends CommandBase {
  /** Creates a new ShooterFeederControllerCommand. */
  public ControllerShooterFeederCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ShooterFeederSubsystem);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!RobotContainer.m_ShooterFeederSubsystem.limitSwitch.get() && !RobotContainer.m_flightStick.getTrigger()) {
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0);
    } else {
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, -0.4);
    }
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
