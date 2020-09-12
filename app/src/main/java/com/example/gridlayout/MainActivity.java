package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.cap,R.drawable.iron,R.drawable.spider,
            R.drawable.widow,R.drawable.panther,R.drawable.thor,
            R.drawable.ant,R.drawable.dare,R.drawable.hawk,R.drawable.ironf,
            R.drawable.jess,R.drawable.luke,R.drawable.punish
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.myGrid);
        gridView.setAdapter(new imageAdapter(mImageIds,this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);
                showDialogBox(item_pos);
            }
        });
    }

    public void showDialogBox(final int item_pos) {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);

        // Getting custom dialog view
        TextView Image_name = dialog.findViewById(R.id.txt_image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_full = dialog.findViewById(R.id.btn_full);
        Button btn_close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        // extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(MainActivity.this,FullView.class);
               i.putExtra("img_id",item_pos);
               startActivity(i);
            }
        });

        dialog.show();
    }

}