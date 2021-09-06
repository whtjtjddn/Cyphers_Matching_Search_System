package com.example.cyphers_matching_search_system

import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import android.os.Bundle
import com.example.cyphers_matching_search_system.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.cyphers_matching_search_system.MainActivity2
import android.widget.EditText
import android.widget.TextView
import com.example.cyphers_matching_search_system.MainActivity
import org.json.JSONException
import java.util.concurrent.ExecutionException

import com.example.util.network.CypherseConnection

class MainActivity : AppCompatActivity() {
    private var Nickname: String? = null
    private var jsonId: JSONArray? = null
    private var Id: String? = null
    private var jsonObject1: JSONObject? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        val editText = findViewById<View>(R.id.nickname) as EditText
        val button = findViewById<View>(R.id.searchMatchHistory_btn) as Button
        val textView = findViewById<View>(R.id.matchHistory) as TextView
        val resultText = arrayOf<String?>(null)
        val resultText1 = arrayOf<String?>(null)
        button.setOnClickListener {
            Nickname = editText.text.toString()
            try {

                CypherseConnection()

                taskUrl = String.format("https://api.neople.co.kr/cy/players?nickname=%s&wordType=full&apikey=FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y", Nickname)
                resultText[0] = Task().execute().get()
                val jsonObject = JSONObject(resultText[0])
                val jsonId = jsonObject.getJSONArray("rows")
                for (i in 0 until jsonId.length()) {
                    jsonObject1 = jsonId.getJSONObject(i)
                }
                Id = jsonObject1!!.getString("playerId")
                taskUrl = String.format("https://api.neople.co.kr/cy/players/%s/matches?gameTypeId=<gameTypeId>&startDate=<startDate>&endDate=<endDate>&limit=<limit>&next=<next>&apikey=FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y", Id)
                resultText1[0] = Task().execute().get()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            textView.text = resultText1[0]
            intent.putExtra("match_Json", resultText1[0])
            startActivity(intent)
        }
    }

    companion object {
        @JvmField
        var taskUrl: String? = null
    }
}