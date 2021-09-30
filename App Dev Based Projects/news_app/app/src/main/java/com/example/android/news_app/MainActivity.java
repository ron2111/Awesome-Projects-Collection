package com.example.android.news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsItemClicked, AdapterView.OnItemSelectedListener {
    String Api_key ="95f963545b6746c4bc1e82827d57b23c";
    String url ="https://newsapi.org/v2/top-headlines?country=in&category=";
    RecyclerView mRecyclerView;
    NewsAdapters myadapter;
    Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.dis);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mSpinner=(Spinner)findViewById(R.id.option);
        mSpinner.setOnItemSelectedListener(this);
        myadapter=new NewsAdapters(this);
        mRecyclerView.setAdapter(myadapter);

    }
    public void Fetchdata(String url){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray json_array=response.getJSONArray("articles");
                            ArrayList<news> news_Array =new ArrayList<>();
                            for(int i = 0;i<json_array.length(); i++){
                                JSONObject Object=json_array.getJSONObject(i);
                                news info = new news(Object.getString("title"),
                                        Object.getString("author"),
                                        Object.getString("url"),
                                        Object.getString("urlToImage"));
                                news_Array.add(info);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Fetchdata(url+adapterView.getSelectedItem().toString()+"&apiKey="+Api_key);
    }

    @Override
    public void onItemClicked(news item) {
        CustomTabsIntent.Builder page = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = page.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

