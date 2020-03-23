package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //vars
    static ArrayList<String> mNames = new ArrayList<>();
    static ArrayList<String> mImageUrls = new ArrayList<>();
    private static final String TAG = "MainActivity";
    static RecyclerViewAdapter adapter;
    private Button updateButton;
    private Button deleteButton;
    private Button insertButton;
    private Button deleteMultipleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateButton=findViewById(R.id.updateButton);
        deleteButton=findViewById(R.id.deleteButton);
        deleteMultipleButton=findViewById(R.id.deleteMultipleButton);
        insertButton=findViewById(R.id.insertButton);
        updateButton.setOnClickListener(this);
        insertButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        deleteMultipleButton.setOnClickListener(this);
        initImageBitmaps();
        mImageUrls.add("https://www.gstatic.com/tv/thumb/v22vodart/172144/p172144_v_v7_ab.jpg");
        mNames.add("Ben 10");

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter( mNames, mImageUrls,this);
        recyclerView.setAdapter(adapter);
        //this line is for setting a horizontal layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.insertButton:
                ArrayList<String> itemsNames=new ArrayList<>();
                ArrayList<String> imageurls=new ArrayList<>();
                int insertIndex=2;
                itemsNames.add("a");
                itemsNames.add("b");
                itemsNames.add("c");
                imageurls.add("https://media.gettyimages.com/photos/heart-letter-a-picture-id171572940?s=612x612");
                imageurls.add("https://cdnaws.sharechat.com/a1c88d2c-b19a-47c8-bb7c-0a227e1c46a4-8530007c-5e67-4e41-99a9-b35d082053bd_compressed_40.jpg");
                imageurls.add("https://media.gettyimages.com/photos/-picture-id157190839?s=2048x2048");
                mImageUrls.addAll(insertIndex,imageurls);
                mNames.addAll(insertIndex,itemsNames);
                adapter.notifyItemRangeChanged(insertIndex,imageurls.size());
                break;
            case R.id.deleteButton:
                int deleteIndex=3;
                mImageUrls.remove(deleteIndex);
                adapter.notifyItemRemoved(deleteIndex);
                break;
            case R.id.deleteMultipleButton:
                int startIndex = 2; // inclusive
                int endIndex = 4;   // exclusive
                int count = endIndex - startIndex;
                mImageUrls.subList(startIndex,endIndex).clear();
                mNames.subList(startIndex,endIndex).clear();
                adapter.notifyItemRangeRemoved(startIndex, count);
                break;
            case R.id.updateButton:
                int updateIndex=2;
                String newName="this is the new name";
                String newImage="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/IBM_Blue_Gene_P_supercomputer.jpg/330px-IBM_Blue_Gene_P_supercomputer.jpg";
                mImageUrls.set(updateIndex,newImage);
                mNames.set(updateIndex,newName);
                adapter.notifyItemChanged(updateIndex);
        }
    }
}
