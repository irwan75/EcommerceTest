package com.ardev.testecommerce.module.detailcataloglist

import android.widget.TextView
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseFragment
import com.ardev.testecommerce.models.Items
import com.ardev.testecommerce.module.cataloglist.ItemFragment

class DetailItemFragment : BaseFragment() {

    private var product: Items = Items.empty()
    private var tvItemName: TextView? = null

    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            DetailItemFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }

    override fun layoutId(): Int = R.layout.fragment_detail_item



    override fun setupView() {
        tvItemName = getmView()?.findViewById(R.id.tvItemName)
        arguments?.let {
            product = it.getSerializable(ItemFragment.ITEM_DATA) as Items
        }
        tvItemName?.let {
            it.text = product.id
        }
    }


}