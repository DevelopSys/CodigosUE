package com.example.trivial

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.trivial.model.Question
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1- Creo la peticion -> Request
        val url = "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            val results = it.getJSONArray("results")
            val gson = Gson()
            for (i in 0..results.length()-1){
                val question: JSONObject = results.getJSONObject(i)
                val objeto: Question = gson.fromJson(question.toString(), Question::class.java)
                /*val title = question.getString("question")
                val incorrectas = question.getJSONArray("incorrect_answers")*/
                Log.v("preguntas",objeto.question?:"no hay titulo")
                //Log.v("preguntas",incorrectas.toString())
            }
        }, {
                Log.v("preguntas","Error en la comunicacion")
        })
        // 2- lanzo la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)

    }
}