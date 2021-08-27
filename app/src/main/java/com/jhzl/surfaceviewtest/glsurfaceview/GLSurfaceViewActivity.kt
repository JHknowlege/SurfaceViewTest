package com.jhzl.surfaceviewtest.glsurfaceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GLSurfaceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val test = TestGLSurfaceView(this)
    }
}