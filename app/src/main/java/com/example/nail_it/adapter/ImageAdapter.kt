package com.example.nail_it.adapter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.nail_it.R

class ImageAdapter(private val context : Context, private val viewPager2: ViewPager2) :
RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val imageList = listOf(
        R.drawable.cta_v1,
        R.drawable.cta_v1,
        R.drawable.cta_v1,
        R.drawable.cta_v1,
        R.drawable.cta_v1,
        R.drawable.cta_v1,
    )
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.iv_slider)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
    }

    private val handler = Handler(Looper.getMainLooper())
    private var currentItem = 0
    private val autoScrollRunnable : Runnable = object : Runnable{
        override fun run() {
            if (currentItem == itemCount){
                currentItem = 0
            }else {
                currentItem++
            }
            viewPager2.setCurrentItem(currentItem, false)
            handler.postDelayed(this, 3000L)

        }

    }

    fun startAutoScroll(){
        handler.postDelayed(autoScrollRunnable, 3000L)

    }
    fun stopAutoScroll(){
        handler.removeCallbacks(autoScrollRunnable)
    }


}
