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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;

public class Indexer extends SubsystemBase {

  WPI_TalonSRX indexerTalon;

  NeutralMode nMode = NeutralMode.Brake;

  DifferentialDrive differentialDrive;

  DoubleSolenoid m_gearShiftSolenoid;

  public Indexer() {
    indexerTalon = new WPI_TalonSRX(16);
  }

  public void initTalons() {
    indexerTalon.clearStickyFaults();
    indexerTalon.configFactoryDefault();
    indexerTalon.setNeutralMode(nMode);;
    indexerTalon.setInverted(true);
  }

  public void arcadeDrive(double moveSpeed) {
    indexerTalon.set(moveSpeed  * IndexerConstants.indexerspeed);
  }
  
  public void indexerIdle(){
    indexerTalon.set(IndexerConstants.idlespeed);
  }
  
  public void safeStop() {
    indexerTalon.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}