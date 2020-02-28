/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;;

public class shiftGears extends CommandBase {
  private final Drivetrain m_arcadian_Drive;
  private final DoubleSolenoid.Value currentGear;

  public shiftGears(Drivetrain subsystem) {
    m_arcadian_Drive = subsystem;
    currentGear = m_arcadian_Drive.getGear();
    addRequirements(m_arcadian_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (currentGear == Value.kForward) {
      m_arcadian_Drive.m_gearShiftSolenoid.set(Value.kReverse);
    } else {
      m_arcadian_Drive.m_gearShiftSolenoid.set(Value.kForward);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
