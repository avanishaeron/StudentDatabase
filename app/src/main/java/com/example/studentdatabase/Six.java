package com.example.studentdatabase;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Six extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e11,e12,e13,e14,e15;
    String s11,s12,s13,s14,s15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
          //  getSupportActionBar().hide();
            getSupportActionBar().setTitle("STUDENT DATABASE");
        }
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        b3=findViewById(R.id.button4);
        e11=findViewById(R.id.edit);
        e12=findViewById(R.id.edit1);
        e13=findViewById(R.id.edit2);
        e14=findViewById(R.id.edit3);
        e15=findViewById(R.id.edit4);
        s11=e11.getText().toString();
        s12=e12.getText().toString();
        s13=e13.getText().toString();
        s14=e14.getText().toString();
        s15=e15.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s11=e11.getText().toString();
                getData();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s11=e11.getText().toString();
                s12=e12.getText().toString();
                s13=e13.getText().toString();
                s14=e14.getText().toString();
                s15=e15.getText().toString();

                update();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s11=e11.getText().toString();
                delete();
            }
        });




    }
    public void getData()
    {
        if(s11.contentEquals("")){
            Toast.makeText(this, "pls give your id", Toast.LENGTH_SHORT).show();
        }
        RequestQueue rq= Volley.newRequestQueue(Six.this);
        String url = Config.DATA_URL+s11;
        StringRequest sr=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showjson(response);
                Toast.makeText(Six.this, "data fetch", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Six.this, "data not fetch", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
    public void showjson(String response){
        String names="";
        String address="";
        String cona="";
        String  coa="";
        try {
            JSONObject jo = new JSONObject(response);
            JSONArray jr = jo.getJSONArray(Config.KEY_RESULT);
            JSONObject jt = jr.getJSONObject(0);
            names = jt.getString(Config.KEY_NAME);
            address = jt.getString(Config.KEY_ADDRESS);
            cona = jt.getString(Config.KEY_CONTACT);
            coa = jt.getString(Config.KEY_COARSE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        e12.setText(names);
        e13.setText(address);
        e14.setText(cona);
        e15.setText(coa);



    }

    public void update(){
        RequestQueue rq = Volley.newRequestQueue(Six.this);
        String url ="https://irecognition.000webhostapp.com/studentdata/update.php";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Six.this, "update..", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Six.this, "not update", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm1=new HashMap<>();
                hm1.put("r",s11);
                hm1.put("n",s12);
                hm1.put("a",s13);
                hm1.put("m",s14);
                hm1.put("c",s15);
                return  hm1;
            }
        };
        rq.add(sr);
    }
    public void  delete(){
        RequestQueue rq = Volley.newRequestQueue(Six.this);
        String url ="https://irecognition.000webhostapp.com/studentdata/delete.php";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Six.this, "delete..", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Six.this, "not delete", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm1=new HashMap<>();
                hm1.put("r",s11);
                hm1.put("n",s12);
                hm1.put("a",s13);
                hm1.put("m",s14);
                hm1.put("c",s15);
                return  hm1;
            }
        };
        rq.add(sr);






    }
}
