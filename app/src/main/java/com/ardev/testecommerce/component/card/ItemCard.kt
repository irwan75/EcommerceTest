package com.ardev.testecommerce.component.card

import android.content.Context
import android.widget.Button
import android.widget.TextView
import com.ardev.testecommerce.R
import com.ardev.testecommerce.base.BaseView
import com.ardev.testecommerce.models.others.Items

class ItemCard : BaseView {

    private var tvId: TextView? = null
    private var tvContent: TextView? = null
    private var tvDetail: TextView? = null
    private var mListener: ActionListener? =null
    private var btnLock: Button? =null

    constructor(context: Context) : super(context)

    override fun getLayoutId(): Int = R.layout.card_item

    override fun initUI() {
        tvId = getmView()?.findViewById(R.id.tvId)
        tvContent = getmView()?.findViewById(R.id.tvContent)
        tvDetail = getmView()?.findViewById(R.id.tvDetail)
        btnLock = getmView()?.findViewById(R.id.btnLock)
    }

    public fun renderProduct(items: Items){
        items.let {
            tvId?.text = it.id.toString()
            tvContent?.text = it.content
            tvDetail?.text = it.details
            btnLock?.setOnClickListener {
                mListener?.lock(it.id.toInt())
            }
        }
    }

    interface ActionListener{
        fun lock(index: Int)
    }
}