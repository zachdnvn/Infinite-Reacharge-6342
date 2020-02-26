/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;;

public class driveArcade extends CommandBase {
  private final Drivetrain m_arcadian_Drive;
  private final DoubleSupplier m_movement;    
  private final DoubleSupplier m_rotation;
  private final boolean m_gear;

  public driveArcade(Drivetrain subsystem, DoubleSupplier movement, DoubleSupplier rotation, Boolean gear) {
      m_arcadian_Drive = subsystem;
      m_movement = movement;
      m_rotation = rotation;
      m_gear = gear;
      addRequirements(m_arcadian_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arcadian_Drive.arcadeDrive(m_movement.getAsDouble(), m_rotation.getAsDouble());
    m_arcadian_Drive.setGear(.getAButton());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // 
    //
    // THERE SHOULD BE NO CASE WHERE THE DRIVE OPERATION IS INTERRUPTED :)
    //
    //
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
