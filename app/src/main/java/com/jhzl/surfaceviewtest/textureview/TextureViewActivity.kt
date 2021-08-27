package com.jhzl.surfaceviewtest.textureview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jhzl.surfaceviewtest.R

class TextureViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_texture_view)
        val testTextureView = findViewById<TestTextureView>(R.id.texture_view)
        findViewById<Button>(R.id.player_mp4_btn).setOnClickListener {
            testTextureView.play("your_name.mp4")
        }

        findViewById<Button>(R.id.pause_btn).setOnClickListener {
            testTextureView.pause();
        }

        findViewById<Button>(R.id.restart_btn).setOnClickListener {
            testTextureView.restart()
        }

        findViewById<Button>(R.id.scale_in_btn).setOnClickListener {
            testTextureView.scaleX = 0.5f
            testTextureView.scaleY = 0.5f
        }

        findViewById<Button>(R.id.scale_out_btn).setOnClickListener {
            testTextureView.scaleX = 1f
            testTextureView.scaleY = 1f
        }
    }
}