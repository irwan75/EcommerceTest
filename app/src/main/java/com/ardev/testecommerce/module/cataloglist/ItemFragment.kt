package com.ardev.testecommerce.module.cataloglist

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseFragment
import com.ardev.testecommerce.component.recyclerview.MyItemRecyclerViewAdapter
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.module.cataloglist.viewmodel.ItemViewModel
import com.ardev.testecommerce.shared.extension.failure
import com.ardev.testecommerce.shared.extension.observe
import com.ardev.testecommerce.shared.extension.viewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class ItemFragment : BaseFragment(), MyItemRecyclerViewAdapter.CallBack {

    private lateinit var adapter: MyItemRecyclerViewAdapter
    private lateinit var listView: RecyclerView

    private val mViewModel: ItemViewModel by lazy {
        ViewModelProvider(this)[ItemViewModel::class.java]
    }

//    private lateinit var mViewModel: ItemViewModel

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
        initRecycleView(listOf<Items>())
    }

    private fun initRecycleView(dataList: List<Items>){
        listView.layoutManager = when {
            columnCount <= 1 -> LinearLayoutManager(getmView()?.context)
            else -> GridLayoutManager(getmView()?.context, columnCount)
        }
        adapter = MyItemRecyclerViewAdapter(getmView()?.context, dataList, this)
        listView.adapter = adapter
    }

//    override fun initializeViewModel() {
//        mViewModel = ViewModelProvider(this)[ItemViewModel::class.java]
//    }

    override fun onItemSelected(item: Items) {
        val bundle = Bundle()
        bundle.putSerializable(ITEM_DATA, item)
        navigate(R.id.action_itemFragment_to_detailItemFragment, false, bundle)
    }

    override fun registerEvent() {
        mViewModel.fetchDataItem()
    }

    override fun initializeViewModelEvent() {
        mViewModel.getItemsData.observe(this){
            if(it==null){
                Toast.makeText(getmView()?.context, "Unseccessful network call", Toast.LENGTH_SHORT).show()
                return@observe
            }
            var items = Items()
            initRecycleView(items.fromListResponseItemsData(it))
        }
    }




}