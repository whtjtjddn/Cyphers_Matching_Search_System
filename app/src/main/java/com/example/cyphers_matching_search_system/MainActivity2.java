package com.example.cyphers_matching_search_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    String nickname_string;
    JSONObject match_string;
    JSONArray match_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String info_data = intent.getStringExtra("match_Json");
        TextView nickname = (TextView)findViewById(R.id.main_2_nickname);

        try {
            JSONObject info = new JSONObject(info_data);
            nickname_string = info.getString("nickname");
            match_string = info.getJSONObject("matches");
            match_array = match_string.getJSONArray("rows");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        nickname.setText(nickname_string);
    }
}