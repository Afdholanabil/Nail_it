package com.example.nail_it

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nail_it.adapter.ListTextAdapter

class KategoriActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListTextAdapter.ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)

        val dataList2 = listOf(
            ListTextAdapter.ItemListAdapter.ItemText("AI Engineer")

        )

        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.addItemDecoration()

        adapter = ListTextAdapter.ItemListAdapter(this, dataList2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
