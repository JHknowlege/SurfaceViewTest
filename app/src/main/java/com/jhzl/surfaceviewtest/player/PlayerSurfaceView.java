package com.jhzl.surfaceviewtest.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;

public class PlayerSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public static final String TAG = PlayerSurfaceView.class.getSimpleName();
    MediaPlayer mediaPlayer = new MediaPlayer();

    public PlayerSurfaceView(Context context) {
        super(context);
        init();
    }

    public PlayerSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlayerSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void play(String assetsPath) throws IOException {
        Log.d(TAG,"play = >"+assetsPath);
        AssetFileDescriptor descriptor = getContext().getAssets().openFd(assetsPath);
        mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
        descriptor.close();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //设置holder关联
        mediaPlayer.setDisplay(getHolder());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.prepare();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void resume() {
        mediaPlayer.start();
    }

    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }
}


