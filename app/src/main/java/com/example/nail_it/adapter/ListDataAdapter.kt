package com.example.nail_it.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nail_it.R
import com.example.nail_it.RecomendationActivity

class ListDataAdapter {
    class ItemListAdapter(private val context: Context, private val list: List<ItemData>) :
        RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {
        data class ItemData(
            val imageId: Int,
            val text1: String,
            val text2: String,
            val text3: String,
            var isSaved: Boolean
        )

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imgList)
            val textView1: TextView = itemView.findViewById(R.id.txtRole)
            val textView2: TextView = itemView.findViewById(R.id.txtCom)
            val textView3: TextView = itemView.findViewById(R.id.txtTyf)
            val savedImageView: ImageView = itemView.findViewById(R.id.imgSaved)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]

            holder.imageView.setImageResource(item.imageId)
            holder.textView1.text = item.text1
            holder.textView2.text = item.text2
            holder.textView3.text = item.text3

            val savedIcon = if (item.isSaved) {
                context.getDrawable(R.drawable.bookmark_24)
            } else {
                context.getDrawable(R.drawable.bookmark_24)
            }
            holder.savedImageView.setImageDrawable(savedIcon)
            holder.savedImageView.setOnClickListener {
                item.isSaved = !item.isSaved
                notifyItemChanged(position)
            }
        }

        override fun getItemCount(): Int = list.size
    }

}