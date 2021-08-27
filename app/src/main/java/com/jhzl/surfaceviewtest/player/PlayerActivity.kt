package com.jhzl.surfaceviewtest.player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jhzl.surfaceviewtest.R;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity {

    private PlayerSurfaceView mPlayerSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mPlayerSurfaceView = findViewById(R.id.playerSurfaceView);
        View playBtn = findViewById(R.id.play_btn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPlayerSurfaceView.play("your_name.mp4");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        View pauseBtn = findViewById(R.id.pause_btn);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayerSurfaceView.pause();
            }
        });

        findViewById(R.id.resume_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayerSurfaceView.isPlaying()){
                    return;
                }
                mPlayerSurfaceView.resume();;
            }
        });




    }
}