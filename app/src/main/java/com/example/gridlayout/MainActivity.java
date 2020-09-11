package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.cap,R.drawable.iron,R.drawable.spiser,
            R.drawable.widow,R.drawable.panther,R.drawable.thor
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.myGrid);
        gridView.setAdapter(new imageAdapter(mImageIds,this));

        gridView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);

            }
        });
    }

    public void showDialogBox(int item_pos) {
        Dialog dialog = new Dialog(this);

        dialog.setContentView();
    }



}