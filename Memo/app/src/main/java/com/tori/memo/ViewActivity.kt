package com.tori.memo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val textViewNote = findViewById<TextView>(R.id.textViewNote)
        val note = intent.getStringExtra("note")
        textViewNote.text = note
    }
}
