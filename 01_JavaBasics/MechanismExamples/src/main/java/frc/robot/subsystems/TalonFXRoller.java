package frc.robot.subsystems;

import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A roller driven by one motor on a Talon FX, controlled by voltage. */
public class TalonFXRoller extends SubsystemBase {
  private final TalonFX motor;

  // Phoenix 6 control requests. Create each once and reuse it every time it is sent.
  private final VoltageOut voltageRequest = new VoltageOut(0.0);
  private final NeutralOut neutralRequest = new NeutralOut();

  /**
   * @param canId the Talon FX's CAN ID on the roboRIO's CAN bus
   */
  public TalonFXRoller(int canId) {
    this.motor = new TalonFX(canId);
  }

  /** 
   * Sends a voltage to the motor. 
   * Positive and negative spin it in opposite directions.
   * */
  public void setVoltage(Voltage voltage) {
    this.motor.setControl(this.voltageRequest.withOutput(voltage));
  }

  /** 
   * Stops the motor, using its configured brake or coast mode. 
   * */
  public void stop() {
    this.motor.setControl(this.neutralRequest);
  }

  /** 
   * Runs the motor at a voltage while the command is scheduled,
   * then stops it. 
   * */
  public Command runVoltage(Voltage voltage) {
    return startEnd(() -> setVoltage(voltage), this::stop);
  }
}
