package com.example.share.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.TextView
import com.example.share.Constants
import com.example.share.R
import com.example.share.showToast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras


        bundle?.let {
            val message = bundle.getString(Constants.USER_MESSAGE_KEY)
            if (message != null) {
                showToast(message)
            }
            val txvShowMessage = findViewById<TextView>(R.id.txvShowMessage)
            txvShowMessage.text = message
        }
    }
}