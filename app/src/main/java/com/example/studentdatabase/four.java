package com.example.studentdatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class four extends AppCompatActivity {
ImageView im1,im2,im3,im4,im5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().setTitle("Click On Any Image To Register");
        }
        im1 = findViewById(R.id.ima1);
        im2 = findViewById(R.id.ima2);
        im3 = findViewById(R.id.ima3);
        im4 = findViewById(R.id.ima4);
        im5 = findViewById(R.id.ima5);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(four.this, five.class);

               intent.putExtra("name",R.drawable.index1);
                startActivity(intent);

            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(four.this, five.class);

                intent.putExtra("name",R.drawable.index2);
                startActivity(intent);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(four.this, five.class);

                intent.putExtra("name",R.drawable.index3);
                startActivity(intent);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(four.this, five.class);

                intent.putExtra("name",R.drawable.index4);
                startActivity(intent);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(four.this, five.class);

                intent.putExtra("name",R.drawable.index5);
                startActivity(intent);
            }
        });













    }








    }

