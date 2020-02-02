/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OI;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class RobotContainer {

//Subsystems
  private final Drivetrain m_robotDrive = new Drivetrain();
  private final Intake m_intake = new Intake();
  
//Joysticks
  Joystick m_driveJoystick = new Joystick(OI.kDriverControllerPort); 
  Joystick m_operatorJoystick = new Joystick(OI.kOperatorControllerPort);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_robotDrive.setDefaultCommand(
      new RunCommand(() -> m_robotDrive
      .arcadeDrive(m_driveJoystick.getY(GenericHID.Hand.kLeft), 
                   m_driveJoystick.getX(GenericHID.Hand.kRight)), m_robotDrive));
  }

  private void configureButtonBindings() {

    new JoystickButton(m_operatorJoystick, Button.kBumperLeft.value)
      .whenHeld(new InstantCommand(m_intake::IntakeIn, m_intake));

    new JoystickButton(m_operatorJoystick, Button.kBumperRight.value)
      .whenHeld(new InstantCommand(m_intake::IntakeOut, m_intake));
  }

public Command getAutonomousCommand() {
	return null;
}



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
