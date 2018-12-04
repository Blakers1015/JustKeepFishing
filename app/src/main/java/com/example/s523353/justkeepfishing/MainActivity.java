package com.example.s523353.justkeepfishing;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton Camera;
        Camera= findViewById(R.id.CameraID);
        Camera.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent Intent3=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(Intent3);
            }
        });

    }
    public void Gallery(View v)
    {
        Intent gallery = new Intent(this,Gallery.class);
        startActivityForResult(gallery,1);
    }
    public void Camera(View V)
    {
        Intent camera = new Intent(this,Search.class);
        startActivityForResult(camera,2);
    }
// use setImageBitmap (bitmap bm) set bitmap as content of image view

//    File path = new File(Environment.getExternalStorageDirectory(),"DCIM/Camera"); DCIM/Camera is the default storage for pictures
//if(path.exists())
//    {
//        String[] fileNames = path.list();
//    }
//for(int i = 0; i < filename.length; i++)
//    {
//        Bitmap mBitmap = Bitmap.decodeFile(path.getPath()+"/"+ fileNames[i]);
//        ///Now set this bitmap on imageview
//    }
}




