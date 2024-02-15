package com.example.nail_it.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nail_it.KategoriActivity
import com.example.nail_it.R

class ListTextAdapter {
    class ItemListAdapter(private val context: KategoriActivity, private val list: List<ItemText>) :
        RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

        data class ItemText(
            val text: String,
            var isCheck: Boolean
        )

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(R.id.txtItem)
            val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_text, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.textView.text = item.text
            holder.checkBox.setOnClickListener {
                item.isCheck = !item.isCheck
                notifyItemChanged(position)
            }
        }

        override fun getItemCount(): Int = list.size

    }
}
