package com.example.gauravsharma.universitymanagement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.displayText);
        val queue = Volley.newRequestQueue(this)
        val url = "http://35.200.253.206/students";
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    val buttons: Array <Button> = arrayOf(
                            findViewById<Button>(R.id.button1),
                            findViewById<Button>(R.id.button2),
                            findViewById<Button>(R.id.button3),
                            findViewById<Button>(R.id.button4),
                            findViewById<Button>(R.id.button5),
                            findViewById<Button>(R.id.button6)
                    )
                    for(but in buttons) {
                        but.setVisibility(View.VISIBLE);
                    }
                    textView.text = ""
                },
                Response.ErrorListener {
                    textView.text = "That didn't work!"
                })

        queue.add(stringRequest)
    }
}
