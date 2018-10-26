package com.example.s523353.justkeepfishing;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Gallery(View v)
    {
        Intent gallery = new Intent(this,Gallary.class);
        startActivityForResult(gallery,1);
    }
    public void Camera(View V)
    {
        Intent camera = new Intent(this,Search.class);
        startActivityForResult(camera,2);
    }
}
