package com.example.cyphers_matching_search_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    static String taskUrl;
    private String Nickname;
    private JSONArray jsonId;
    private String Id;
    private JSONObject jsonObject1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.nickname);
        Button button = (Button) findViewById(R.id.searchMatchHistory_btn);
        TextView textView = (TextView) findViewById(R.id.matchHistory);

        final String[] resultText = {null};
        final String[] resultText1 = {null};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nickname = editText.getText().toString();
                try {
                    taskUrl = String.format("https://api.neople.co.kr/cy/players?nickname=%s&wordType=full&apikey=FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y", Nickname);
                    resultText[0] = new Task().execute().get();

                    JSONObject jsonObject = new JSONObject(resultText[0]);
                    jsonId = jsonObject.getJSONArray("rows");

                    for(int i = 0;i<jsonId.length();i++)
                    {
                        jsonObject1 = jsonId.getJSONObject(i);
                    }
                    Id = jsonObject1.getString("playerId");

                    taskUrl = String.format("https://api.neople.co.kr/cy/players/%s/matches?gameTypeId=<gameTypeId>&startDate=<startDate>&endDate=<endDate>&limit=<limit>&next=<next>&apikey=FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y",Id);

                    resultText1[0] = new Task().execute().get();

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                textView.setText(resultText1[0]);
            }
        });

    }
}
/*
void JSONParse(String jsonString) throws JSONException {
    String myId;
    JSONArray jsonArray = new JSONArray(jsonString);
    for(int i = 0; i<jsonArray.length();i++)
    {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
    }
}*/
