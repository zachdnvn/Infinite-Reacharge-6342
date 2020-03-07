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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OI;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.driveArcade;
import frc.robot.commands.operateIndexer;
import frc.robot.commands.shiftGears;
import frc.robot.commands.shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

//Subsystems
  private final Drivetrain m_robotDrive = new Drivetrain();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  private final Indexer m_indexer = new Indexer();

//Joysticks
  public XboxController m_driveJoystick = new XboxController(OI.kDriverControllerPort); 
  public Joystick m_operatorJoystick = new Joystick(OI.kOperatorControllerPort);


  public RobotContainer() {
    configureButtonBindings();
    
    //Default Drivetrain Command
    m_robotDrive.setDefaultCommand(new driveArcade(m_robotDrive,
    ()->m_driveJoystick.getY(Hand.kLeft),
    ()->m_driveJoystick.getX(Hand.kRight)) 
    );

    //Default Indexer Command
    m_indexer.setDefaultCommand(new operateIndexer(m_indexer,
    ()->m_operatorJoystick.getY(Hand.kLeft))
    );
  }

  private void configureButtonBindings() {
    new JoystickButton(m_operatorJoystick, Button.kY.value)
      .whileHeld(new IntakeIn(m_intake));

    new JoystickButton(m_operatorJoystick, Button.kA.value)
      .whileHeld(new IntakeOut(m_intake));
      
    new JoystickButton(m_driveJoystick, Button.kBumperRight.value)
    .whenReleased(new shiftGears(m_robotDrive));

    new JoystickButton(m_operatorJoystick, Button.kA.value)
    .toggleWhenPressed(new shoot(m_shooter));

   }

public Command getAutonomousCommand() {
	return null;
}
}