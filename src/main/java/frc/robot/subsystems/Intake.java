/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;


public class Intake extends SubsystemBase {
  WPI_TalonSRX intakeTalon = new WPI_TalonSRX(14);

  
  public void IntakeIn(){
    intakeTalon.set(IntakeConstants.rollerspeed);
  }

  public void IntakeOut(){
    intakeTalon.set(IntakeConstants.rollerspeed * -1);
  }

  public void IntakeStop(){
    intakeTalon.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
