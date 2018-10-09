package com.example.gauravsharma.universitymanagement

import android.content.Intent
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
        checkServerStatus(textView);
    }

    private fun checkServerStatus (textView: TextView) {
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, getResources().getString(R.string.serverCheckURL),
                Response.Listener<String> { response ->
                    makeButtonsVisible(textView);
                },
                Response.ErrorListener {
                    textView.text = getResources().getString(R.string.errorText);
                })

        queue.add(stringRequest)
    }

    private fun makeButtonsVisible (textView: TextView) {
        val buttons: Array <Button> = arrayOf(
                findViewById<Button>(R.id.button1),
                findViewById<Button>(R.id.button2),
                findViewById<Button>(R.id.button3),
                findViewById<Button>(R.id.button4),
                findViewById<Button>(R.id.button5),
                findViewById<Button>(R.id.button6)
        )
        for(button in buttons) {
            button.setVisibility(View.VISIBLE)
        }
        textView.text = ""
    }

    public fun setClickHandler (view: View) {
        when(view.id) {
            R.id.button1 ->  getStudentDetails();
            R.id.button2 ->  getStudentOfClass();
            R.id.button3 ->  admitNewStudent();
            R.id.button4 ->  updateStudentName();
            R.id.button5 ->  deleteStudent();
            R.id.button6 ->  enrollStudentToClass();
        }
    }

    private fun getStudentDetails () {
        val intent = Intent(this, GetStudentDetailsActivity::class.java)
        startActivity(intent)
    }

    private fun getStudentOfClass () {

    }

    private fun admitNewStudent () {

    }

    private fun updateStudentName () {

    }

    private fun deleteStudent () {

    }

    private fun enrollStudentToClass () {

    }
}
