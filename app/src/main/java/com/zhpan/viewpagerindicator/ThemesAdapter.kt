package com.zhpan.viewpagerindicator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThemesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return PagerItemViewHolder(layoutInflater.inflate(R.layout.item_test, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = items.let { items[position] }
        initPagerLayout(viewHolder as PagerItemViewHolder, item)
    }

    private fun initPagerLayout(holder: PagerItemViewHolder, item: String) {

        holder.tvTheme.text = item
    }


    private class PagerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTheme: TextView = itemView.findViewById(R.id.tvTheme)
    }

    fun update(itemsViewModels: List<String>) {
        items = itemsViewModels
        notifyDataSetChanged()
    }
}