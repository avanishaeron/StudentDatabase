package com.example.studentdatabase;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    EditText t1,t2,t3,t4,t5;
    Button b1,b2;
    String s1,s2,s3,s4,s5;
    View v;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_register, container, false);
        t1=v.findViewById(R.id.usereditt);
        t2=v.findViewById(R.id.username);
        t3=v.findViewById(R.id.useraddr);
        t4=v.findViewById(R.id.usercona);
        t5=v.findViewById(R.id.usercoa);
        b1=v.findViewById(R.id.button);
        b2=v.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=t1.getText().toString();
                s2=t2.getText().toString();
                s3=t3.getText().toString();
                s4=t4.getText().toString();
                s5=t5.getText().toString();
                register();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Six.class);
                startActivity(i);

            }
        });
        return v;
    }
    public void register() {
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        String url="https://irecognition.000webhostapp.com/studentdata/register.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "data register", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "data not register", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm1=new HashMap<String, String>();
                hm1.put("r",s1);
                hm1.put("n",s2);
                hm1.put("a",s3);
                hm1.put("m",s4);
                hm1.put("c",s5);


                return  hm1;
            }
        };
        rq.add(sr);
    }

}
