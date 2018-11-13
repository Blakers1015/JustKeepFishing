package com.example.s523353.justkeepfishing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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
    GPSTracker gps;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        int CAMERA_CAPTURE_IMAGE_REQUEST_CODE;
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            gps = new GPSTracker(AndroidGPSTrackingActivity.this);

            if (resultCode == RESULT_OK)
            {
                previewCapturedImage();
                if(gps.canGetLocation())
                {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                } else {
                    // Can't get location.
                    // GPS or network is not enabled.
                    // Ask user to enable GPS/network in settings.

                }

            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "Cancelled", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Error!", Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }



}
