package com.example.s523353.justkeepfishing;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
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
    //Use an ArrayList for these images since we're taking the latest images from camera
    //and storing them in the gallery
    //syntax is something like ArrayList <File> (file being the type of data it is)
    //leave the ArrayList empty, it should get bigger as we take more pictures
    //could possibly keep the stock images we have just to shorten the presentation
    //Should use a GridView for gallery
    //Bitmap mBitmap = null;
    private Integer[] images={R.drawable.fish1,R.drawable.fish2,R.drawable.fish3,
            R.drawable.fish4,R.drawable.fish5,R.drawable.fish6, R.drawable.fish7, R.drawable.fish8};

    File path = new File(Environment.getExternalStorageDirectory(), "DCIM/Camera");




    String[] fileNames;


    private ImageView imageview;

    String data[] = {"Bluegill", "Bass", "Carp", "Pike"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (path != null)
        {
            Log.d("images path","path "+path.toString()+" exists "+path.getPath());
        }
        else

        {
            Log.d("images path", "Path is null");
        }


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

        if (path.exists())

        {
            fileNames = path.list();
            //Log.d("images path","path "+path.toString()+" exists "+path.getPath());
        }
//        Log.d("images path","path "+path.toString()+" does not exist "+path.getPath());
//        Log.d("images path",path.getPath()+"length "+path.listFiles().length);
//        Log.d("images path",path.list().toString());
        Bitmap mBitmap = null;
        for (int i = 0; i < fileNames.length; i++) {


            //Bitmap.
            mBitmap = BitmapFactory.decodeFile(path.getPath() + "/" + fileNames[0]);
            ///Now set this bitmap on imageview
        }



        android.widget.Gallery imgGallery = (android.widget.Gallery) findViewById(R.id.gallery);

        imgGallery.setAdapter(new ImageAdapter(this));
        imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setImageBitmap(mBitmap);
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


