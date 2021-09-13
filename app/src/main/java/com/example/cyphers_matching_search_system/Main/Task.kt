package com.example.cyphers_matching_search_system

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class Task : AsyncTask<String?, Void?, String?>() {
    var clientKey = "#########################"
    private var str: String? = null
    private var receiveMsg: String? = null
    private val ID = "########"
    override fun doInBackground(vararg params: String?): String? {
        var url: URL? = null
        try {
            url = URL(MainActivity.taskUrl) // 서버 URL
            val conn = url.openConnection() as HttpURLConnection
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
            conn.setRequestProperty("x-waple-authorization", clientKey)
            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                val tmp = InputStreamReader(conn.inputStream, "UTF-8")
                val reader = BufferedReader(tmp)
                val buffer = StringBuffer()
                while (reader.readLine().also { str = it } != null) {
                    buffer.append(str)
                }
                receiveMsg = buffer.toString()
                Log.i("receiveMsg : ", receiveMsg!!)
                reader.close()
            } else {
                Log.i("결과", conn.responseCode.toString() + "Error")
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return receiveMsg
    }
}