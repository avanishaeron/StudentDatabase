package com.example.studentdatabase;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    Button b1;
    EditText e1, e2;
    String s1, s2;
    CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().setTitle("LOGIN PAGE");
        }
        b1 = findViewById(R.id.click4);
        e1 = findViewById(R.id.edittt);
        e2 = findViewById(R.id.edittt2);
        ch=findViewById(R.id.show);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if (s1.contentEquals("admin") && s2.contentEquals("1234")) {
                    Intent i = new Intent(Second.this, third.class);
                    startActivity(i);
                    Toast.makeText(Second.this, "login success", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Second.this, "not login", Toast.LENGTH_SHORT).show();

                }

            }
        });
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b)
                {
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else{
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
    }

