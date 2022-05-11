// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ControllerShooterLauncherCommand extends CommandBase {
  /** Creates a new ControllerShooterLaungerCommand. */
  public double mod = 0;
  public ControllerShooterLauncherCommand() {
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_flightStick.getRawButton(7)) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.3 + mod);
    } else if (RobotContainer.m_flightStick.getRawButton(8)) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.55 + mod);
    } else if (RobotContainer.m_flightStick.getRawButton(10)) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.8 + mod);
    } else {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0);
    }
    if (RobotContainer.m_flightStick.getRawButtonPressed(7)||RobotContainer.m_flightStick.getRawButtonPressed(8)||RobotContainer.m_flightStick.getRawButtonPressed(10)) {
      mod = 0;
    } else if (RobotContainer.m_flightStick.getRawButtonPressed(11)) {
      mod = mod - 0.05;
    } else if (RobotContainer.m_flightStick.getRawButtonPressed(12)) {
      mod = mod + 0.05;
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
