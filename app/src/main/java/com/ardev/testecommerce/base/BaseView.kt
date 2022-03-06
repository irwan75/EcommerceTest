package com.ardev.testecommerce.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

abstract class BaseView : RelativeLayout {

    private var mView: View? = null

    fun getmView(): View? {
        return mView
    }

    constructor(context: Context) : super(context) {
        inflateView(context)
        initUI()
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        inflateView(context)

        initUI()
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        inflateView(context)

        initUI()
    }


    abstract fun getLayoutId(): Int

    private fun inflateView(context: Context): View? {
        if (null == mView) {
            mView = View.inflate(context, getLayoutId(), this)
        }
        return mView!!
    }

    open fun initUI() {
    }
}