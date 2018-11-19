package com.example.s523353.justkeepfishing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class Gallery extends AppCompatActivity {

    File path = new File(Environment.getExternalStorageDirectory(), "DCIM/Camera");
    String[] fileNames;

    private Integer[] images = {R.drawable.fish1, R.drawable.fish2, R.drawable.fish3,
            R.drawable.fish4, R.drawable.fish5, R.drawable.fish6, R.drawable.fish7, R.drawable.fish8};
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        Intent intent = getIntent();

//        if (path.exists())
//
//        {
            fileNames = path.list();
//        }
        Log.d("images path",path.getPath()+"length "+path.listFiles().length);
//        Log.d("images path",path.list().toString());

//        for (int i = 0; i < fileNames.length; i++)
//
//        {
//
////            Bitmap mBitmap = Bitmap.decodeFile(path.getPath() + "/" + fileNames[i]);
//            ///Now set this bitmap on imageview
//        }


        android.widget.Gallery imgGallery = (android.widget.Gallery) findViewById(R.id.gallery);

        imgGallery.setAdapter(new ImageAdapter(this));
        imageview = (ImageView) findViewById(R.id.imageView);
        imgGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), "Image " + arg2, Toast.LENGTH_SHORT).show();
                imageview.setImageResource(images[arg2]);
            }
        });

    }


    public class ImageAdapter extends BaseAdapter {
        private Context context;
        int imageBackground;

        public ImageAdapter(Context context) {

            this.context = context;
        }

        @Override
        public int getCount() {

            return images.length;
        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg0) {

            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(images[arg0]);
            return imageView;
        }
    }

}

