package com.ardev.testecommerce.module.cataloglist

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseFragment
import com.ardev.testecommerce.component.recyclerview.MyItemRecyclerViewAdapter
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : BaseFragment(), MyItemRecyclerViewAdapter.CallBack {

    private lateinit var adapter: MyItemRecyclerViewAdapter
    private lateinit var listView: RecyclerView

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"
        const val ITEM_DATA = "item_data"

    }

    private var columnCount = 1

    override fun layoutId() = R.layout.fragment_item_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun setupView() {
        listView = getmView()!!.findViewById(R.id.list)
        initRecycleView()
    }

    private fun initRecycleView(){
        listView.layoutManager = when {
            columnCount <= 1 -> LinearLayoutManager(context)
            else -> GridLayoutManager(context, columnCount)
        }
        adapter = MyItemRecyclerViewAdapter(context, PlaceholderContent.ITEMS, this)
        listView.adapter = adapter
    }

    override fun onItemSelected(item: Items) {
        val bundle = Bundle()
        bundle.putSerializable(ITEM_DATA, item)
        navigate(R.id.action_itemFragment_to_detailItemFragment, false, bundle)
    }


}