/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  WPI_TalonSRX leftShooterTalon;
  WPI_TalonSRX rightShooterTalon;

  NeutralMode nMode = NeutralMode.Brake;

  public Shooter() {

    leftShooterTalon = new WPI_TalonSRX(14);
    rightShooterTalon = new WPI_TalonSRX(15);
    
    leftShooterTalon.follow(rightShooterTalon);

  }

  public void initTalons(){
    // Left Shooter Talon
    leftShooterTalon.clearStickyFaults();
    leftShooterTalon.configFactoryDefault();
    leftShooterTalon.setNeutralMode(nMode);
    // Right Shooter Talon
    rightShooterTalon.clearStickyFaults();
    rightShooterTalon.configFactoryDefault();
    rightShooterTalon.setNeutralMode(nMode);
  }

  public void shoot(){
    rightShooterTalon.set(ShooterConstants.rollerspeed);
  }
  public void safeStop() {
    leftShooterTalon.set(ControlMode.PercentOutput, 0);
    rightShooterTalon.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
