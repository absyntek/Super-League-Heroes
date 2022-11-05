package com.super_league.heroes

import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieDrawable
import com.super_league.heroes.databinding.ActivityRadioBinding

class RadioActivity : AppCompatActivity() {
    lateinit var bind : ActivityRadioBinding

    val mediaPlayer1 = MediaPlayer()
    val mediaPlayer2 = MediaPlayer()

    val TAG = "RADIO_ACT"
    var sp: SoundPool = SoundPool.Builder().build()

    var canChangeSound: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRadioBinding.inflate(layoutInflater)
        setContentView(bind.root)

        mediaPlayer1.apply {
            isLooping = true
            val ins = resources.openRawResourceFd(R.raw.radio_noise)
            setDataSource(ins.fileDescriptor, ins.startOffset, ins.length)
        }
        sp.load(this, R.raw.test_tmp, 0)
        sp.setOnLoadCompleteListener { soundPool, i, i2 ->
            sp.play(i, 0F, 0F, 0, 1, 0.5F)
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
                        bind.layoutMod.isInvisible = true
                        val volume = getVolume(0.45F, 0.5F, value)
                        sp.setVolume(0, volume.reversedVolume,volume.reversedVolume)
                        mediaPlayer1.setVolume(volume.volume, volume.volume)
                        //mediaPlayer2.setVolume(volume.reversedVolume,volume.reversedVolume)
                        /*if (!mediaPlayer2.isPlaying){
                            mediaPlayer2.stop()
                        }*/
                    }
                    in 0.5F .. 0.55F -> {
                        bind.layoutMod.isInvisible = false
                    }
                    in 0.55F .. 0.6F -> {
                        bind.layoutMod.isInvisible = false
                        val volume = getVolume(0.55F, 0.6F, value)

                        mediaPlayer1.setVolume(volume.reversedVolume,volume.reversedVolume)
                        sp.setVolume(0, volume.volume, volume.volume)
                        //mediaPlayer2.setVolume(volume.volume, volume.volume)
                    }
                }
            }catch (e:Exception){
                Log.e("SeekChange", "SeekChange", e)
            }
            Log.i("SeekChange", value.toString())
        }
        bind.layoutMod.addOnChangeListener { slider, value, fromUser ->
            if (canChangeSound){
                canChangeSound = false
                mediaPlayer2.stop()
                sp.load(this, R.raw.test_tmp, 0)
                sp.setOnLoadCompleteListener { soundPool, i, i2 ->
                    val pitch = when {
                        value <=0.25F -> 0.5F
                        value >= 0.74F -> 1.5F
                        else -> value * 2
                    }
                    soundPool.play(i, 1F, 1F, 0, 1, pitch)
                    canChangeSound = true
                }
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
        sp.stop(0)
        super.onDestroy()
    }

    data class VolumeItem(val volume:Float, val reversedVolume: Float)
}