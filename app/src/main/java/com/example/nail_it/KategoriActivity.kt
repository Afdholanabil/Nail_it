package com.example.nail_it

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class KategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var recyclerView: RecyclerView
        val data = arrayOf("Text 1", "Text 2", "Text 3", "Text 4", "Text 5")


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)
    }

}