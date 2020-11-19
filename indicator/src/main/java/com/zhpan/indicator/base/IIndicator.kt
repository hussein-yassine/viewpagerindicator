package com.zhpan.indicator.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.yarolegovich.discretescrollview.DiscreteScrollView

import com.zhpan.indicator.option.IndicatorOptions


/**
 * <pre>
 * Created by zhangpan on 2019-09-02.
 * Description:
</pre> *
 */
interface IIndicator : ViewPager.OnPageChangeListener, DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>{

    fun notifyDataChanged()

    fun setIndicatorOptions(options: IndicatorOptions)

}
