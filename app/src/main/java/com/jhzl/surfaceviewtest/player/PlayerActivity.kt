package com.jhzl.surfaceviewtest.player

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jhzl.surfaceviewtest.R
import java.io.IOException

class PlayerActivity : AppCompatActivity() {
    private var mPlayerSurfaceView: PlayerSurfaceView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        mPlayerSurfaceView = findViewById(R.id.playerSurfaceView)
        val playBtn = findViewById<View>(R.id.play_btn)
        playBtn.setOnClickListener {
            try {
                mPlayerSurfaceView?.play("your_name.mp4")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        val pauseBtn = findViewById<View>(R.id.pause_btn)
        pauseBtn.setOnClickListener { mPlayerSurfaceView?.pause() }
        findViewById<View>(R.id.resume_btn).setOnClickListener(View.OnClickListener {
            if (mPlayerSurfaceView?.isPlaying == true) {
                return@OnClickListener
            }
            mPlayerSurfaceView?.resume()
        })


        findViewById<Button>(R.id.scale_in_btn).setOnClickListener {
            mPlayerSurfaceView?.scaleX = 0.5f
            mPlayerSurfaceView?.scaleY = 0.5f
        }

        findViewById<Button>(R.id.scale_out_btn).setOnClickListener {
            mPlayerSurfaceView?.scaleX = 1f
            mPlayerSurfaceView?.scaleY = 1f
        }

        findViewById<Button>(R.id.rotate_btn).setOnClickListener {
            mPlayerSurfaceView?.rotation = mPlayerSurfaceView?.rotation!! +90
        }
    }
}