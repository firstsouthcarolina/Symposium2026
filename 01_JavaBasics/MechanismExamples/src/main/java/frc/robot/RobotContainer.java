// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.RollerConstants;
import frc.robot.subsystems.TalonFXRoller;
import frc.robot.subsystems.ThriftyNovaRoller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  private final ThriftyNovaRoller m_novaRoller =
      new ThriftyNovaRoller(RollerConstants.kNovaCanId, RollerConstants.kNovaMotorType);
  private final TalonFXRoller m_talonFXRoller = new TalonFXRoller(RollerConstants.kTalonFXCanId);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Each motor runs while its button is held and stops when the button is released.

    // A and B: the Thrifty Nova roller, one direction each.
    m_driverController.a().whileTrue(m_novaRoller.runVoltage(RollerConstants.kRollerVoltage));
    m_driverController
        .b()
        .whileTrue(m_novaRoller.runVoltage(RollerConstants.kRollerVoltage.unaryMinus()));

    // X and Y: the Talon FX roller, one direction each.
    m_driverController.x().whileTrue(m_talonFXRoller.runVoltage(RollerConstants.kRollerVoltage));
    m_driverController
        .y()
        .whileTrue(m_talonFXRoller.runVoltage(RollerConstants.kRollerVoltage.unaryMinus()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.none();
  }
}
