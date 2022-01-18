package frc.robot.commands;

import frc.robot.RobotContainer;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class RobotPositionInitial extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
 
//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
  public RobotPositionInitial(DriveTrain dt, double speed, double angle, double time) {
    int location = DriverStation.getInstance().getLocation();
    if(location == 1){
				addCommands(
          new TurnAngle(dt, speed, angle),
          //new turnAngleRight(dt, speed, angle),
				  new Forward(dt, speed, time)
        );
      }
      if(location == 2){
        addCommands(
          new Forward(dt, speed, (time + 1))
        );
      }
      if(location == 3){
        addCommands(
          new TurnAngle(dt, speed, angle = -angle),
        //new turnAngleLeft(dt, speed, angle),
        new Forward(dt, speed, time)
        );
      }
    }
  }
