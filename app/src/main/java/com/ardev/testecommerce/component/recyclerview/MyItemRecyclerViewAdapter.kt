package com.ardev.testecommerce.component.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.ardev.testecommerce.R

import com.ardev.testecommerce.placeholder.PlaceholderContent.PlaceholderItem
import com.ardev.testecommerce.models.others.Items

class MyItemRecyclerViewAdapter(
    private  val context: Context?,
    private val values: List<Items>,
    private val callBack: CallBack
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.card_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  item = values[position]
        holder.tvId.text = item.id
        holder.tvContent.text = item.content
        holder.tvDetail.text = item.details
        holder.parentLayout.setOnClickListener {
            var items = Items(id = item.id, content = item.content, details = item.details)
            callBack.onItemSelected(items)
        }
    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvDetail: TextView = itemView.findViewById(R.id.tvDetail)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        val parentLayout: RelativeLayout = itemView.findViewById(R.id.parentLayoutItemCard)
    }

    interface CallBack {
        fun onItemSelected( item: Items)
    }



}