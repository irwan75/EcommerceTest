package com.ardev.testecommerce.component.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.ardev.testecommerce.placeholder.PlaceholderContent.PlaceholderItem
import com.ardev.testecommerce.databinding.FragmentItemBinding
import com.ardev.testecommerce.models.Items

class MyItemRecyclerViewAdapter(
    private  val context: Context?,
    private val values: List<PlaceholderItem>,
    private val callBack: CallBack
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.idView.setOnClickListener {
            val items = Items()
            items.content = item.content
            items.details = item.details
            items.id = item.id
            callBack.onItemSelected(items)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    interface CallBack {
        fun onItemSelected( item:  Items)
    }

}