package com.example.recyclerview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditName extends AppCompatActivity {
    Button saveButton;
    Button deleteButton;
    EditText editText;
    Integer position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIncomingIntent();
        setContentView(R.layout.activity_edit_name);
        saveButton=findViewById(R.id.saveButton);
        deleteButton=findViewById(R.id.deleteButton);
        editText=findViewById(R.id.editText);
        editText.setText(MainActivity.mNames.get(position));
        saveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                MainActivity.mNames.set(position,editText.getText().toString());
                MainActivity.adapter.notifyItemChanged(position);
                finish();
           }
        });
       deleteButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                MainActivity.mNames.remove(position);
                MainActivity.mImageUrls.remove(position);
                MainActivity.adapter.notifyItemRemoved(position);
                finish();
           }
       });

    }

    private void getIncomingIntent(){
        position=getIntent().getIntExtra("position",0);
    }

}
