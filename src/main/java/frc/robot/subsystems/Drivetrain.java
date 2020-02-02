/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {

  WPI_TalonFX leftFrontTalon;
  WPI_TalonFX leftBackTalon;
  WPI_TalonFX rightFrontTalon;
  WPI_TalonFX rightBackTalon;

  DifferentialDrive differentialDrive;

  public Drivetrain() {

      leftFrontTalon = new WPI_TalonFX(10);
      leftBackTalon = new WPI_TalonFX(11);
      rightFrontTalon = new WPI_TalonFX(12);
      rightBackTalon = new WPI_TalonFX(13);
      
      leftBackTalon.follow(leftFrontTalon);
      rightBackTalon.follow(rightFrontTalon);

  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed * DriveConstants.speedscalar, rotateSpeed * DriveConstants.rotatescalar);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}