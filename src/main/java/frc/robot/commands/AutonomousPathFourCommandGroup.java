// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
 
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathFourCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathFourCommandGroup. */
  public AutonomousPathFourCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new StartAutonCommand());
    addCommands(new AutoMoveBackwardPIDCommand(30));
    addCommands(new AutoShooterFeederCommand(0.9, 1));
    addCommands(new AutoTurnRightPIDCommand(3, 0.05));
    addCommands(new StopTimeCommand(0.25));
    addCommands(new AutoMoveBackwardPIDLONGCommand(84));
    addCommands(new StopTimeCommand(0.5));
    addCommands(new AutoMoveForwardPIDLONGCommand(84));
    addCommands(new AutoTurnLeftPIDCommand(2, 0.05));
    addCommands(new StopTimeCommand(0.25));
    addCommands(new AutoShooterFeederCommand(0.9, 1));
 
  }
}
 
 
 

