// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
    //Gyros
  public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    //Declaring Motors Talon Left
  private WPI_TalonSRX m_leftMaster = new WPI_TalonSRX(RobotContainer.m_leftMasterID);
  private WPI_TalonSRX m_leftSlave = new WPI_TalonSRX(RobotContainer.m_leftSlaveID);
  
  //Declaring Motors Talon Right
  private WPI_TalonSRX m_rightMaster = new WPI_TalonSRX(RobotContainer.m_rightMasterID);
  private WPI_TalonSRX m_rightSlave = new WPI_TalonSRX(RobotContainer.m_rightSlaveID);

  //Declaring differential drive
  private  DifferentialDrive difdrive = new DifferentialDrive(m_leftMaster, m_rightMaster);

  public DriveTrain() {
     //Creating group
     m_rightSlave.follow(m_rightMaster);
     m_leftSlave.follow(m_leftMaster);
 
     //Default config
     m_rightSlave.configFactoryDefault();
     m_rightMaster.configFactoryDefault();
     m_leftSlave.configFactoryDefault();
     m_leftMaster.configFactoryDefault();
 
     //Inverted config - review this later
     m_leftSlave.setInverted(InvertType.FollowMaster);
		 m_rightSlave.setInverted(InvertType.FollowMaster);

     m_rightMaster.setInverted(false);
     m_rightSlave.setInverted(false);
     m_leftMaster.setInverted(false); 
  }

  public void arcadeDrive(double movSpeed, double rotSpeed, boolean squareInputs) {
    difdrive.arcadeDrive(movSpeed*RobotContainer.LimitSpeed, rotSpeed*RobotContainer.LimitSpeed, squareInputs);
  }

  // public void rotateAngle(double angle){
  //   double kP = 0;
  //   double error = angle - gyro.getAngle();
  //   double speed = kP * error;
  //   if((error < 0) && (error > 0.5)){
  //     difdrive.arcadeDrive(0, 0, false);
  //   }else{
  //     difdrive.arcadeDrive(speed / RobotContainer.LimitSpeed, -speed / RobotContainer.LimitSpeed, false);
  //   }
  // }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}