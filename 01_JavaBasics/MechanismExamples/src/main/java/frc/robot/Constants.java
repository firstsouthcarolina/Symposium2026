// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Volts;

import com.thrifty.core.Motor.MotorType;
import edu.wpi.first.units.measure.Voltage;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class RollerConstants {
    // Placeholder CAN IDs: set these to match the controllers on your robot.
    public static final int kNovaCanId = 1;
    public static final int kTalonFXCanId = 2;

    // The motor wired to the Nova. The Nova needs this to drive the motor correctly.
    public static final MotorType kNovaMotorType = MotorType.NEO;

    // Voltage for each button. One button sends +kRollerVoltage, the other -kRollerVoltage.
    public static final Voltage kRollerVoltage = Volts.of(1.0);
  }
}
