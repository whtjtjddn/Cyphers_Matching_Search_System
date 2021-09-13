package com.example.cyphers_matching_search_system.main

import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import org.json.JSONArray
import android.os.Bundle
import com.example.cyphers_matching_search_system.R
import android.view.View
import android.widget.TextView
import org.json.JSONException

class MainActivity2 : AppCompatActivity() {
    var nickname_string: String? = null
    var match_string: JSONObject? = null
    var match_array: JSONArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val info_data = intent.getStringExtra("match_Json")
        val nickname = findViewById<View>(R.id.main_2_nickname) as TextView
        try {
            val info = JSONObject(info_data)
            nickname_string = info.getString("nickname")
            val match_string = info.getJSONObject("matches")
            match_array = match_string.getJSONArray("rows")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        nickname.text = nickname_string
    }
}