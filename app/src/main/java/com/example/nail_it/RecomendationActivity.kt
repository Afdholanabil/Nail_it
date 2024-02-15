package com.example.nail_it

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nail_it.adapter.ListDataAdapter

class RecomendationActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListDataAdapter.ItemListAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendation)

        // Prepare your data
        val dataList = listOf(
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage, "UI/UX Designer", "INDICO", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage1, "Game UI/UX Designer", "Alegrium", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage2, "Front End Developer", "Gojek", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage3, "Backend Engineer (Laravel)", "DOT Indonesia", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage4, "Data Scientist", "Ninja Van", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage5, "Front End Developer", "Hostinger", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage6, "Mobile Developer (Flutter)", "Stealth Startup", "Fulltime", true),

        )

        // Find the RecyclerView
        recyclerView = findViewById(R.id.recyclerRecomendation)
        recyclerView.addItemDecoration(ItemSpacingDecoration(8))

        // Create the adapter
        adapter = ListDataAdapter.ItemListAdapter(this, dataList)

        // Set the layout manager (optional)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter
        recyclerView.adapter = adapter
    }
}

class ItemSpacingDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = spacing
    }
}
