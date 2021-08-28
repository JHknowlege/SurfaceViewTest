package com.jhzl.surfaceviewtest.window

import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.jhzl.surfaceviewtest.R
import com.jhzl.surfaceviewtest.player.PlayerSurfaceView

class TestWindow {

    fun show(context: Context) {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var mContext = context
        var mRootView = View.inflate(context.applicationContext, R.layout.window_test, null)


        val params = WindowManager.LayoutParams()
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = mContext.resources.getDimension(R.dimen.decor_max_size).toInt()
        params.gravity = Gravity.CENTER
        params.format = PixelFormat.RGBA_8888
        windowManager.addView(mRootView, params)


        val surfaceView = mRootView.findViewById<PlayerSurfaceView>(R.id.surface_view);
        mRootView.findViewById<Button>(R.id.play_btn).setOnClickListener {
            surfaceView.play("your_name.mp4")
        }

        mRootView.findViewById<Button>(R.id.close_btn).setOnClickListener {
            windowManager.removeView(mRootView)
        }

    }


}