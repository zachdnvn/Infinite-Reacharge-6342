/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OI;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class RobotContainer {

//Subsystems
  private final Drivetrain m_robotDrive = new Drivetrain();
  private final Intake m_intake = new Intake();

//Comands
  private final Command IntakeIn = new IntakeIn(m_intake);
  private final Command IntakeOut = new IntakeOut(m_intake);

//Joysticks
  XboxController m_driveJoystick = new XboxController(OI.kDriverControllerPort); 
  Joystick m_operatorJoystick = new Joystick(OI.kOperatorControllerPort);


  public RobotContainer() {

    //Configure Button Bindings
    configureButtonBindings();

    //Default Commands
    m_robotDrive.setDefaultCommand(
        new RunCommand(() -> m_robotDrive
            .arcadeDrive(m_driveJoystick.getY(Hand.kLeft),
                         m_driveJoystick.getX(Hand.kRight)), m_robotDrive));
    // m_intake.setDefaultCommand(
    //     new RunCommand(() -> m_intake
    //     .IntakeStop(), m_intake));
  }

  private void configureButtonBindings() {

    new JoystickButton(m_operatorJoystick, Button.kBumperRight.value)
      .whileHeld(new IntakeIn(m_intake));

    new JoystickButton(m_operatorJoystick, Button.kBumperLeft.value)
      .whileHeld(new IntakeOut(m_intake));

    // new JoystickButton(m_operatorJoystick, Button.kBumperRight.value)
    //   .whileHeld(new InstantCommand(m_intake::IntakeOut, m_intake));
  }

public Command getAutonomousCommand() {
	return null;
}

}
