package com.jhzl.surfaceviewtest.simple;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class SimpleSurfaceViewTest extends SurfaceView implements SurfaceHolder.Callback {
    public static final String TAG = SimpleSurfaceViewTest.class.getSimpleName();
    public SimpleSurfaceViewTest(Context context) {
        super(context);
        init();
    }

    public SimpleSurfaceViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleSurfaceViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.d(TAG,"surfaceCreated thread => "+Thread.currentThread().getName());
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG,"surfaceChanged = >"+Thread.currentThread().getName());

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Log.d(TAG,"surfaceDestroyed = >"+Thread.currentThread().getName());
    }
}
