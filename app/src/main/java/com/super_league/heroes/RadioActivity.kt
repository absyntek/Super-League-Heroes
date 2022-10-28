package com.super_league.heroes

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.core.view.isVisible
import com.super_league.heroes.databinding.ActivityRadioBinding

class RadioActivity : AppCompatActivity() {
    lateinit var bind : ActivityRadioBinding

    val mediaPlayer1 = MediaPlayer()
    val mediaPlayer2 = MediaPlayer()

    val TAG = "RADIO_ACT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRadioBinding.inflate(layoutInflater)
        setContentView(bind.root)

        mediaPlayer1.apply {
            isLooping = true
            val ins = resources.openRawResourceFd(R.raw.radio_noise)
            setDataSource(ins.fileDescriptor, ins.startOffset, ins.length)
        }

        mediaPlayer2.apply {
            isLooping = true
            val ins = resources.openRawResourceFd(R.raw.test_tmp)
            setDataSource(ins.fileDescriptor, ins.startOffset, ins.length)
            setVolume(0F, 0F)
        }
        val mediaPlayer3 = MediaPlayer()
        val mediaPlayer4 = MediaPlayer()
        val mediaPlayer5 = MediaPlayer()

        mediaPlayer1.prepareAsync()
        mediaPlayer1.setOnPreparedListener {
            it.start()
        }
        mediaPlayer2.prepareAsync()
        mediaPlayer2.setOnPreparedListener {
            it.start()
        }

        bind.slider.addOnChangeListener { slider, value, fromUser ->
            try {
                when (value) {
                    in 0.45F .. 0.5F -> {
                        bind.layoutMod.isVisible = false
                        val volume = getVolume(0.45F, 0.5F, value)
                        mediaPlayer1.setVolume(volume.volume, volume.volume)
                        mediaPlayer2.setVolume(volume.reversedVolume,volume.reversedVolume)
                    }
                    in 0.5F .. 0.55F -> {
                        bind.layoutMod.isVisible = true
                    }
                    in 0.55F .. 0.6F -> {
                        bind.layoutMod.isVisible = false
                        val volume = getVolume(0.55F, 0.6F, value)

                        mediaPlayer1.setVolume(volume.reversedVolume,volume.reversedVolume)
                        mediaPlayer2.setVolume(volume.volume, volume.volume)
                    }
                }
            }catch (e:Exception){
                Log.e("SeekChange", "SeekChange", e)
            }
            Log.i("SeekChange", value.toString())
        }

        bind.seekBa2.addOnChangeListener { slider, value, fromUser ->
            try {
                mediaPlayer1.setVolume(value, value)
                mediaPlayer2.setVolume(value, value)
            }catch (e:Exception){
                Log.e(TAG, "onCreate: ", e)
            }
        }
    }

    private fun getVolume(valueMin:Float, valueMax: Float, actualValue: Float) : VolumeItem {
        val interval = valueMax - valueMin
        val toReturn = (valueMax - actualValue) * (1F / interval)
        val reversed = (toReturn - 1) * -1
        return VolumeItem(toReturn, reversed)
    }

    override fun onDestroy() {
        mediaPlayer1.stop()
        mediaPlayer2.stop()
        super.onDestroy()
    }

    data class VolumeItem(val volume:Float, val reversedVolume: Float)
}