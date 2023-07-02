package com.example.share.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.share.Constants
import com.example.share.R
import com.example.share.showToast

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
        val btnSendToNextActivity = findViewById<Button>(R.id.btnSendToNextActivity)
        val btnShareToOtherApps = findViewById<Button>(R.id.btnShareToOtherApps)
        val btnShowHobbiesList = findViewById<Button>(R.id.btnShowHobbiesList)
        btnShowToast.setOnClickListener {
            Log.i(TAG, "Button is Clicked !")
            showToast(resources.getString(R.string.btn_clicked), Toast.LENGTH_LONG)
        }

        btnSendToNextActivity.setOnClickListener {
            val etUserMessage = findViewById<EditText>(R.id.etUserMessage)
            val message: String = etUserMessage.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MESSAGE_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val etUserMessage = findViewById<EditText>(R.id.etUserMessage)
            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        btnShowHobbiesList.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}