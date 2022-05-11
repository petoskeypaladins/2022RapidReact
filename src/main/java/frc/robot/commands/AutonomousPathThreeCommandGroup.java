// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathThreeCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathThreeCommandGroup. */
  public AutonomousPathThreeCommandGroup() {
    //PATH THREE: Picks up 1-2 balls, pushes 1-2 away, starts closest to own alliance's terminal
    addCommands(new AutoDownIntakeCommand(1));
    addCommands(new MoveAndIntakeCommandGroup(18, 0.4, 3));
    addCommands(new FeedAndShootParallelCommandGroup(6));
    addCommands(new MoveAndIntakeCommandGroup(10, 0.4, 2));
  }
}
