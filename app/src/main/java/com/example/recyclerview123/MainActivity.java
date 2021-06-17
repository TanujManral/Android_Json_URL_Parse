package com.example.recyclerview123;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import android.widget.ListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private TextView mTextViewResult;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button buttonParse = findViewById(R.id.button_parse);
        mQueue = Volley.newRequestQueue(MainActivity.this);


        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });


    }


    private void jsonParse() {
        String url = "http://www.json-generator.com/api/json/get/capSoAstHC?indent=2";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("dir_list");
                            ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject dir_list = jsonArray.getJSONObject(i);

                                String dir_name = dir_list.getString("dir_name");
                                int approve_request = dir_list.getInt("approve_request");
                                String description = dir_list.getString("description");

                                int admin_mobile = dir_list.getInt("admin_mobile");

                                int total_member = dir_list.getInt("total_member");
                               // String admin_photo = dir_list.getString("admin_photo");
                                int dir_id = dir_list.getInt("dir_id");
                                String admin_name = dir_list.getString("admin_name");
                                String admin_email = dir_list.getString("admin_email");
                                int type = dir_list.getInt("type");

                                String dir_logo = dir_list.getString("dir_logo");








                                final ListView list = findViewById(R.id.list);




                                arrayList.add(new SubjectData("Admin Name="+admin_name,"Dir_Id="+String.valueOf(dir_id),"Description="+ description,"Dir_Name="+dir_name,"Approve_Request="+String.valueOf(approve_request),"Mobile="+String.valueOf(admin_mobile),"Mail="+admin_email,"Total_Member="+String.valueOf(total_member),"Type="+String.valueOf(type),dir_logo));
                                //,dir_logo, admin_photo
                                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, arrayList);

                                list.setAdapter(customAdapter);
                            }


                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}
