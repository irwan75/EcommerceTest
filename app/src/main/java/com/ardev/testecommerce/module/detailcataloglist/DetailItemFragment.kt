package com.ardev.testecommerce.module.detailcataloglist

import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseFragment
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.module.cataloglist.ItemFragment
import com.ardev.testecommerce.module.detailcataloglist.viewmodel.DetailItemViewModel

class DetailItemFragment : BaseFragment() {

    private var product: Items = Items.empty()
    private var tvItemName: TextView? = null
    private var tvCount: TextView? = null
    private var btnIncrement: Button? =null

    private lateinit var mViewModel: DetailItemViewModel

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

        tvCount?.text = mViewModel.getValueTemporary().toString()
        tvItemName?.let {
            it.text = product.id
        }
    }


    override fun registerEvent() {
        btnIncrement?.setOnClickListener {
            mViewModel.incrementValue()
            tvCount?.text = mViewModel.getValueTemporary().toString()
        }
    }

    override fun initializeViewModel() {
        mViewModel = ViewModelProvider(this).get(DetailItemViewModel::class.java)
    }




}