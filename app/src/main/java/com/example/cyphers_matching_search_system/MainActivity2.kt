package com.example.cyphers_matching_search_system

import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import org.json.JSONArray
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.json.JSONException

class MainActivity2 : AppCompatActivity() {
    var nickname_string: String? = null
    var grade_string: String? = null
    var clan_string: String? = null
    var raiting_string: String? = null
    var tier_string: String? = null
    var matches_string: String? = null
    var match_string: JSONObject? = null
    var match_array: JSONArray? = null
    private var json_Match_Object: JSONObject? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val info_data = intent.getStringExtra("match_Json")
        val nickname = findViewById<View>(R.id.main_2_nickname) as TextView
        val grade = findViewById<View>(R.id.main_2_grade) as TextView
        val clan = findViewById<View>(R.id.main_2_clan) as TextView
        val rating = findViewById<View>(R.id.main_2_raitingPoint) as TextView
        val tier = findViewById<View>(R.id. main_2_Tier) as TextView
        val matches = findViewById<View>(R.id.main_2_matches) as TextView
        try {
            val info = JSONObject(info_data)
            nickname_string = info.getString("nickname")
            grade_string = info.getString("grade") + "급"
            clan_string = info.getString("clanName")
            raiting_string = info.getInt("ratingPoint").toString()
            tier_string = info.getString("tierName")
            val match_string = info.getJSONArray("records")
            for(i in 0 until match_string.length())
            {
                json_Match_Object = match_string.getJSONObject(i)
            }
            /*if ("rating" == json_Match_Object!!.getString("gameTypeId"))
            {
                matches_string = json_Match_Object!!.getString("winCount")
            }*/
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        nickname.text = nickname_string
        grade.text = grade_string
        clan.text = clan_string
        rating.text = raiting_string
        tier.text = tier_string
        matches.text = matches_string

    }
}