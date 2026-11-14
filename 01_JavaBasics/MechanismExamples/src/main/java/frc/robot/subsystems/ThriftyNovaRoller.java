package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.thrifty.core.Motor.MotorType;
import com.thrifty.core.MotorControl;
import com.thrifty.nova.Nova;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A roller driven by one motor on a Thrifty Nova, controlled by voltage. */
public class ThriftyNovaRoller extends SubsystemBase {
  private final Nova motor;

  /**
   * @param canId the Nova's CAN ID
   * @param motorType the motor plugged into the Nova (NEO, Minion, Pulsar or brushed)
   */
  public ThriftyNovaRoller(int canId, MotorType motorType) {
    this.motor = new Nova(0, canId, motorType);
  }

  /** 
   * Sends a voltage to the motor. 
   * Positive and negative spin it in opposite directions. 
   * */
  public void setVoltage(Voltage voltage) {
    this.motor.control(MotorControl.voltage(voltage.in(Volts)));
  }

  /** 
   * Stops the motor. 
   * */
  public void stop() {
    this.motor.stopMotor();
  }

  /** 
   * Runs the motor at a voltage while the command is scheduled, then stops it. 
   * */
  public Command runVoltage(Voltage voltage) {
    return startEnd(() -> setVoltage(voltage), this::stop);
  }
}
