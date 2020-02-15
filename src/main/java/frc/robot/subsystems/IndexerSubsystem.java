/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.IndexerConstants;

public class IndexerSubsystem extends SubsystemBase {

  private final CANSparkMax upperConveyorMotor = new CANSparkMax(IndexerConstants.kUpperConveyorMotorPort, MotorType.kBrushless);
  private final CANSparkMax lowerConveyorMotor= new CANSparkMax(IndexerConstants.kLowerConveyorMotorPort, MotorType.kBrushless);

  private final CANEncoder m_upperConveyorEncoder = new CANEncoder(upperConveyorMotor);
  private final CANEncoder m_lowerConveyorEncoder = new CANEncoder(lowerConveyorMotor);


  public IndexerSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void moveUpperConveyor(double speed) {
      upperConveyorMotor.set(speed);
      // Temp testing w/ lower too
      if(speed != 0){
        lowerConveyorMotor.set(IndexerConstants.kLowerConveyorSpeedDefault);
      }
      lowerConveyorMotor.set(0);
  }

  public void moveLowerConveyor(double speed) {
    lowerConveyorMotor.set(speed);
  }
}
