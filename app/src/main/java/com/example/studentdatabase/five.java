package com.example.studentdatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class five extends AppCompatActivity {
ImageView imgs;
Button b1;
FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }
        fm=getSupportFragmentManager();
        imgs=findViewById(R.id.pic);
        Bundle bundle=getIntent().getExtras();

        imgs.setImageResource(bundle.getInt("name"));


        b1=findViewById(R.id.b);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i =new Intent(get)
                fm.beginTransaction().replace(R.id.frame,new RegisterFragment()).commit();
            }
        });
    }
}
