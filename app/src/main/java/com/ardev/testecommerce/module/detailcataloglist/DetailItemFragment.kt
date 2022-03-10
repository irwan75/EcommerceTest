package com.ardev.testecommerce.module.detailcataloglist

import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseFragment
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.module.cataloglist.ItemFragment
import com.ardev.testecommerce.module.cataloglist.viewmodel.ItemViewModel
import com.ardev.testecommerce.module.detailcataloglist.viewmodel.DetailItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailItemFragment : BaseFragment() {

    private var product: Items = Items.empty()
    private var tvItemName: TextView? = null
    private var tvCount: TextView? = null
    private var btnSave: Button? = null
    private var btnLoad: Button? = null
    private var tvData: TextView? = null
    private var btnIncrement: Button? =null
    private var btnUpdate: Button? =null
    private var btnDelete: Button? =null

    private val mViewModel: DetailItemViewModel by lazy {
        ViewModelProvider(this)[DetailItemViewModel::class.java]
    }

    override fun layoutId(): Int = R.layout.fragment_detail_item

    override fun initializeData() {
        arguments?.let {
            product = it.getSerializable(ItemFragment.ITEM_DATA) as Items
        }
    }

    override fun setupView() {
        tvItemName = getmView()?.findViewById(R.id.tvItemName)
        tvCount = getmView()?.findViewById(R.id.tvCount)
        btnIncrement = getmView()?.findViewById(R.id.btnAdd)
        btnSave = getmView()?.findViewById(R.id.btnSave)
        btnLoad = getmView()?.findViewById(R.id.btnLoad)
        btnUpdate = getmView()?.findViewById(R.id.btnUpdate)
        btnDelete = getmView()?.findViewById(R.id.btnDelete)
        tvData = getmView()?.findViewById(R.id.tvData)

        tvCount?.text = mViewModel.getValueTemporary().toString()
        tvItemName?.let {
            it.text = product.details
        }
    }


    override fun registerEvent() {
        btnIncrement?.setOnClickListener {
            mViewModel.incrementValue()
            tvCount?.text = mViewModel.getValueTemporary().toString()
        }
        btnSave?.setOnClickListener {
            mViewModel.saveDataItem(product)
        }
        btnLoad?.setOnClickListener {
            product.id?.let { it1 -> mViewModel.fetchItem(it1) }
        }
        btnDelete?.setOnClickListener {
            product.let {
                mViewModel.deleteItem(product)
            }
        }
        btnUpdate?.setOnClickListener {
            product.id?.let {
                var itemCustom = Items()
                itemCustom.id = it
                itemCustom.content = "test lorem ipsum"
                itemCustom.details = "lorem ipsum dolor lorem ipsum dolor"
                mViewModel.updateItemById(it, itemCustom)
            }
        }
    }

    override fun initializeViewModelEvent() {
        mViewModel.getItem.observe(this){
            if(it==null){
                Toast.makeText(getmView()?.context, "Unseccessful network call", Toast.LENGTH_SHORT).show()
                return@observe
            }
            tvData?.text = it.content
        }
    }





}