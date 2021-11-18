package com.example.teht2


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var mSensor: Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


    }
    override fun onAccuracyChanged(p0: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        //TODO: Tänne koodi
        val x = p0!!.values[0]
        val y = p0!!.values[1]

        findViewById<TextView>(R.id.textView).text =
            "Y:" + y + ", X:" + x

        findViewById<MyView>(R.id.myView).moveBall(x, y)
    }
    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}