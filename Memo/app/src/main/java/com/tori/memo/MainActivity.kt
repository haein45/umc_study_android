package com.tori.memo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNote: EditText
    private var savedNote: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNote = findViewById(R.id.editTextNote)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java).apply {
                putExtra("note", editTextNote.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (savedNote.isNotEmpty()) {
            editTextNote.setText(savedNote)
        }
    }

    override fun onPause() {
        super.onPause()
        savedNote = editTextNote.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("메모 작성")
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("예") { _, _ -> }
            .setNegativeButton("아니오") { _, _ -> savedNote = "" }
            .show()
    }
}
