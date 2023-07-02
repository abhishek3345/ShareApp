package com.example.share.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.Supplier
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.share.R
import com.example.share.adapters.HobbiesAdapter

class HobbiesActivity : AppCompatActivity() {
    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, com.example.share.models.Supplier.hobbies)
        recyclerView.adapter = adapter
    }
}