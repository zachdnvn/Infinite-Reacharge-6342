/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  WPI_TalonFX leftFrontTalon;
  WPI_TalonFX leftBackTalon;
  WPI_TalonFX rightFrontTalon;
  WPI_TalonFX rightBackTalon;

  NeutralMode nMode = NeutralMode.Coast;

  DifferentialDrive differentialDrive;

  DoubleSolenoid m_gearShiftSolenoid;

  Boolean currentGear = true; // CHANGE THIS BASED ON THE GEAR YOU ARE STARTING ON

  Boolean isPaused = false;

  public Drivetrain() {

    leftFrontTalon = new WPI_TalonFX(12);
    leftBackTalon = new WPI_TalonFX(13);
    rightFrontTalon = new WPI_TalonFX(10);
    rightBackTalon = new WPI_TalonFX(11);

    leftBackTalon.follow(leftFrontTalon);
    rightBackTalon.follow(rightFrontTalon);

    differentialDrive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);

    m_gearShiftSolenoid = new DoubleSolenoid(0,1);
  }

  public void initTalons() {
    // Front Left
    leftFrontTalon.clearStickyFaults();
    leftFrontTalon.configFactoryDefault();
    leftFrontTalon.setNeutralMode(nMode);
    leftFrontTalon.enableVoltageCompensation(true);
    // Front Right
    rightFrontTalon.clearStickyFaults();
    rightFrontTalon.configFactoryDefault();
    rightFrontTalon.setNeutralMode(nMode);
    rightFrontTalon.enableVoltageCompensation(true);
    // Back Left
    leftBackTalon.clearStickyFaults();
    leftBackTalon.configFactoryDefault();
    leftBackTalon.setNeutralMode(nMode);
    leftBackTalon.enableVoltageCompensation(true);
    // Back Right
    rightBackTalon.clearStickyFaults();
    rightBackTalon.configFactoryDefault();
    rightBackTalon.setNeutralMode(nMode);
    rightBackTalon.enableVoltageCompensation(true);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
    
  public void changeGear() {
    currentGear = !currentGear;
    if(currentGear == true) {
      m_gearShiftSolenoid.set(Value.kReverse);
    }
    else {
      m_gearShiftSolenoid.set(Value.kForward);
    }
  }

  public void safeStop() {
    leftFrontTalon.set(ControlMode.PercentOutput, 0);
    rightFrontTalon.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}