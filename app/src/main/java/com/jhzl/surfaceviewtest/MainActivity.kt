package com.jhzl.surfaceviewtest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jhzl.surfaceviewtest.glsurfaceview.GLSurfaceViewActivity
import com.jhzl.surfaceviewtest.player.PlayerActivity
import com.jhzl.surfaceviewtest.simple.SimpleSurfaceViewActivity
import com.jhzl.surfaceviewtest.textureview.TextureViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.simple_life_cycle_btn).setOnClickListener {
            val intent = Intent(this@MainActivity, SimpleSurfaceViewActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.player_mp4_btn).setOnClickListener {
            val intent = Intent(this@MainActivity, PlayerActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.gl_surfaceview_btn).setOnClickListener{
            val intent = Intent(this@MainActivity,GLSurfaceViewActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.texture_btn).setOnClickListener{
            val intent = Intent(this@MainActivity,TextureViewActivity::class.java)
            startActivity(intent)
        }

    }
}