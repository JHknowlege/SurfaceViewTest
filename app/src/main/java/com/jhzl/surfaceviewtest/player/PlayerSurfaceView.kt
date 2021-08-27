package com.jhzl.surfaceviewtest.player

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.jhzl.surfaceviewtest.player.PlayerSurfaceView
import java.io.IOException

class PlayerSurfaceView : SurfaceView, SurfaceHolder.Callback {
    var mediaPlayer = MediaPlayer()

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun init() {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {}
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    @Throws(IOException::class)
    fun play(assetsPath: String) {
        Log.d(TAG, "play = >$assetsPath")
        mediaPlayer.reset()
        val descriptor = context.assets.openFd(assetsPath)
        mediaPlayer.setDataSource(descriptor.fileDescriptor, descriptor.startOffset, descriptor.length)
        descriptor.close()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        //设置holder关联
        mediaPlayer.setDisplay(holder)
        mediaPlayer.setOnPreparedListener { mp -> mp.start() }
        mediaPlayer.prepare()
    }

    fun stop() {
        mediaPlayer.stop()
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun resume() {
        mediaPlayer.start()
    }

    val isPlaying: Boolean
        get() = mediaPlayer.isPlaying

    companion object {
        val TAG = PlayerSurfaceView::class.java.simpleName
    }
}