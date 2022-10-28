package com.super_league.heroes.stardroid.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import com.super_league.heroes.stardroid.control.AstronomerModel
import javax.inject.Inject

/**
 * Connects the rotation vector to the model code.
 */
class SensorModelAdaptor @Inject internal constructor(private val model: AstronomerModel) :
  SensorEventListener {
  override fun onSensorChanged(event: SensorEvent) {
    // do something with the model
  }

  override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
    // Do nothing.
  }
}