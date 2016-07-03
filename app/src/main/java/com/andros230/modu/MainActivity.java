package com.andros230.modu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.andros230.network.VolleyCallBack;
import com.andros230.network.VolleyPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements VolleyCallBack {
    private ListView LV_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        new VolleyPost(this, this, "http://192.168.0.100:8080/Modu/EventList", null).post();
    }

    private void init() {
        LV_list = (ListView) findViewById(R.id.listView);
    }


    @Override
    public void volleySolve(String result) {
        if (result != null) {
            Log.e("----",result);
            Gson gson = new Gson();
            List<Map<String, Object>> list = gson.fromJson(result, new TypeToken<List<Map<String, Object>>>() {
            }.getType());
            Main_listView_adapter adapter = new Main_listView_adapter(this, list);
            LV_list.setAdapter(adapter);
        } else {
            Log.e("----------", "result is null");
        }
    }
}
