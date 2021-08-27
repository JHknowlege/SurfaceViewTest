package com.jhzl.surfaceviewtest.textureview

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.graphics.SurfaceTexture
import android.media.AudioManager
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.Surface
import android.view.TextureView

class TestTextureView : TextureView, TextureView.SurfaceTextureListener {
    private val mediaPlayer = MediaPlayer();
    private var _surface: Surface? = null
    constructor(context: Context) : super(context) {
        initLogic()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLogic()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initLogic()
    }


    private fun initLogic() {
        surfaceTextureListener = this

    }

    fun play(assetPath: String) {
        mediaPlayer.reset()
        val descriptor = context.assets.openFd(assetPath);
        mediaPlayer.setDataSource(descriptor.fileDescriptor, descriptor.startOffset, descriptor.length)
        descriptor.close()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.setOnPreparedListener {
            it.start()
        }
        mediaPlayer.setSurface(_surface)
        mediaPlayer.prepare()
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        _surface = Surface(surface)
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        return true
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun restart(){
        mediaPlayer.start()
    }

}