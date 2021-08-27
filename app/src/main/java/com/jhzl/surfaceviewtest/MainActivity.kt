package com.jhzl.surfaceviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jhzl.surfaceviewtest.player.PlayerActivity;
import com.jhzl.surfaceviewtest.simple.SimpleSurfaceViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       findViewById(R.id.simple_life_cycle_btn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, SimpleSurfaceViewActivity.class);
               startActivity(intent);
           }
       });

       findViewById(R.id.player_mp4_btn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
               startActivity(intent);
           }
       });

    }
}