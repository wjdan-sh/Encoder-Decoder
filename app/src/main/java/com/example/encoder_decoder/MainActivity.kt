package com.example.encoder_decoder

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var RC: RecyclerView
    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var phrases: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RC = findViewById(R.id.RV)
        phrases = ArrayList()

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        btn1 = findViewById(R.id.but1)
        btn2 = findViewById(R.id.but2)

        RC.adapter = RVaddapter(phrases)
        RC.layoutManager = LinearLayoutManager(this)

        btn1.setOnClickListener {
           val phrase= ed1.text.toString()
            phrases.add(phrase)
           val enphrase = Encode(phrase).toString()

            phrases.add(enphrase)
            ed1.text.clear()
            ed1.clearFocus()
            RC.adapter?.notifyDataSetChanged()
            RC.scrollToPosition(phrases.size-1)


        }

        btn2.setOnClickListener {
            val phrase= ed2.text.toString()
            phrases.add(phrase)
            val enphrase = Decode(phrase).toString()

            phrases.add(enphrase)
            ed2.text.clear()
            ed2.clearFocus()
            RC.adapter?.notifyDataSetChanged()
            RC.scrollToPosition(phrases.size-1)
        }

    }

    fun Encode(masseg: String): StringBuffer? {
        val result = StringBuffer()
        for (i in 0 until masseg.length) {
            if (Character.isWhitespace(masseg[i])|| Character.isDigit(masseg[i])) {
                val ch = masseg[i]
                result.append(ch)
            } else if (Character.isUpperCase(masseg[i])) {
                val ch = ((masseg[i].toInt() +
                        13 - 65) % 26 + 65).toChar()
                result.append(ch)
            } else {
                val ch = ((masseg[i].toInt() +
                        13 - 97) % 26 + 97).toChar()
                result.append(ch)
            }
        }
        return result
    }
    fun Decode(masseg: String): StringBuffer? {
        val result = StringBuffer()
        for (i in 0 until masseg.length) {
            if (Character.isWhitespace(masseg[i])|| Character.isDigit(masseg[i])) {
                val ch = masseg[i]
                result.append(ch)
            } else if (Character.isUpperCase(masseg[i])) {
                val ch = ((masseg[i].toInt() +
                        13 - 65) % 26 + 65).toChar()
                result.append(ch)
            } else {
                val ch = ((masseg[i].toInt() +
                        13 - 97) % 26 + 97).toChar()
                result.append(ch)
            }
        }
        return result
    }


}