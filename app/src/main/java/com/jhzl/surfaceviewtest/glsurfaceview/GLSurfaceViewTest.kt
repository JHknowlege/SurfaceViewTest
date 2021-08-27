package com.jhzl.surfaceviewtest.glsurfaceview

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.SurfaceHolder
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class GLSurfaceViewTest : GLSurfaceView, SurfaceHolder.Callback{
    constructor(context: Context?) : super(context){
        _init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        _init()
    }

    private fun _init() {
        holder.addCallback(this)
        setRenderer(TestRender())
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
    override fun surfaceDestroyed(holder: SurfaceHolder) {}


    private class TestRender : Renderer {
        private var mVB: FloatBuffer? = null
        val buffer = floatArrayOf(
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f,
                -0.5f, 0.5f, 0.0f)

        init {
            val vbb: ByteBuffer = ByteBuffer.allocateDirect(buffer.size * 4)
            vbb.order(ByteOrder.nativeOrder())
            mVB = vbb.asFloatBuffer()
            mVB?.put(buffer)
            mVB?.position(0)
        }

        override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        }

        override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
            gl.glViewport(0, 0, width, height);
        }

        override fun onDrawFrame(gl: GL10) {
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
            gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
            gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f)
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVB)
            gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6)
        }
    }
}