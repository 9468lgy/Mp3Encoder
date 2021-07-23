package com.demo.mp3encodertest

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.mp3_encoder_btn)

        val file = File(getExternStorage(this, "voice.mp3"))
        if (!file.exists()) {
            file.createNewFile()
        }

        btn.setOnClickListener {
            val encoder = Mp3Encoder()
            val pcmPath = getExternStorage(this, "vocal.pcm")
            val audioChannels = 2
            val bitRate = 128 * 1024
            val sampleRate = 44100
            val mp3Path = getExternStorage(this, "voice.mp3")

            Log.i(TAG, "Encode 准备初始化")
            val ret = encoder.init(pcmPath, audioChannels, bitRate, sampleRate, mp3Path)
            Log.i(TAG, "Encode 初始化结束")
            if (ret >= 0) {
                Log.i(TAG, "Encode 准备encode")
                encoder.encode()
                Log.i(TAG, "Encode encode结束")
                encoder.destroy()
                Log.i(TAG, "Encode destroy结束")
            } else {
                Log.i(TAG, "Encoder Initialized Failed...")
            }
        }
    }

    fun getExternStorage(context: Context, field: String?): String? {

        return context.filesDir.absolutePath + "/${field}"
    }
}