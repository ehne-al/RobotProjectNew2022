// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveArcade;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RobotPositionInitial;
import frc.robot.subsystems.DriveTrain;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //Subsystems
  final static DriveTrain driveTrain = new DriveTrain(); 

  //Commands
  private final RobotPositionInitial m_autoCommand = new RobotPositionInitial(driveTrain, 0.4, 70, 1.5);
  private final DriveArcade DriveArcadeCommand = new DriveArcade(driveTrain);
  //private final static RobotPositionInitial robotPositionInitial = new RobotPositionInitial(driveTrain);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  public static final double LimitSpeed = 0.7;
  public static final int m_leftMasterID = 2;
  public static final int m_leftSlaveID = 1;
  public static final int m_rightMasterID = 4;
  public static final int m_rightSlaveID = 3;

  // Controller ID
  public static final int controllerID = 0;
  public static final int buttonID = 3;

  // Controller
  public static XboxController controller = new XboxController(controllerID);

  // gyro ID
  public static final int gyroID = 0;

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public Command getDriveArcade() {
    // An ExampleCommand will run in autonomous
    return DriveArcadeCommand;
  }


  //public Command runPositionInitial() {
   // return robotPositionInitial;
//}

}
