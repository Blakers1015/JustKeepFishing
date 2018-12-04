package com.example.s523353.justkeepfishing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.File;

public class Gallery extends AppCompatActivity {
    private ListView listSearch;
    private EditText editSearch;
    private ArrayAdapter<String> adapter;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    //Bitmap mbitmap = null;
    private Integer [] images={R.drawable.bluegill,R.drawable.bluegill2,R.drawable.bass,R.drawable.bass2,
            R.drawable.carp, R.drawable.carp2,  R.drawable.pike, R.drawable.pike2};

    File path = new File (Environment.getExternalStorageDirectory(), "DCIM/Camera");
    private ImageView imageview;
    String [] fileNames;


    String data[] = {"bluegill", "bass", "carp", "pike"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        listSearch = (ListView)findViewById(R.id.list);
        editSearch = (EditText)findViewById(R.id.searchBar);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_search, R.id.searchText, data);
        listSearch.setAdapter(adapter);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Gallery.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Intent intent = getIntent();
        if (path.exists()){
            fileNames = path.list();
            Log.d("length",""+fileNames.length);
        }
        Bitmap mbitmap = null;
        for (int i = 0; i < fileNames.length; i++)
        {
            mbitmap = BitmapFactory.decodeFile(path.getPath() + "/" + fileNames[0]);
        }
        android.widget.Gallery imgGallery = (android.widget.Gallery) findViewById(R.id.gallery);

        imgGallery.setAdapter(new ImageAdapter(this));
        imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setImageBitmap(mbitmap);
        imgGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Toast.makeText(getApplicationContext(), "Image " + arg2,Toast.LENGTH_SHORT).show();
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

