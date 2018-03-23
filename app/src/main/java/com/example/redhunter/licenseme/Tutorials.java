package com.example.redhunter.licenseme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Tutorials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



    }

    public void toSign(View view){
        Intent intent = new Intent(this,TSigns.class);
        startActivity(intent);
    }
    public void toVideo(View view){
        Intent intent = new Intent(this,TVideos.class);
        startActivity(intent);
    }
}
