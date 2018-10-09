package com.example.gauravsharma.universitymanagement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class GetStudentDetailsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_student_details)
        populateSpinner();
    }

    private fun populateSpinner () {
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(this, R.array.get_student_details_drop_down, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this;
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        if(pos == 1) {
            findViewById<EditText>(R.id.studentID).setVisibility(View.VISIBLE)
            findViewById<Button>(R.id.button7).setEnabled(false)
        } else {
            findViewById<EditText>(R.id.studentID).setVisibility(View.GONE)
            findViewById<Button>(R.id.button7).setEnabled(true)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        val textView = findViewById<TextView>(R.id.displayText);
        textView.text = getResources().getString(R.string.nothingSelectedYet);
    }
}