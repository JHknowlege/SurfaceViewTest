package com.jhzl.surfaceviewtest.thread;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class ThreadSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private boolean needDraw = true;

    public ThreadSurfaceView(Context context) {
        super(context);
        init();
    }

    public ThreadSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThreadSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        getHolder().addCallback(this);
        init();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        needDraw = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }


    @Override
    public void run() {
        while (needDraw) {
            Canvas canvas = null;
            try {
                canvas = getHolder().lockCanvas();
            } finally {
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }


}
