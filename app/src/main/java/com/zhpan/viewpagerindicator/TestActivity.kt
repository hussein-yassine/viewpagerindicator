package com.zhpan.viewpagerindicator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    private var themesAdapter: ThemesAdapter = ThemesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val list = listOf("1","2","3","4")
        themesAdapter.update(list)
        vpThemes.adapter = themesAdapter
        vpThemes.setOffscreenItems(3)
        vpThemes.setOverScrollEnabled(false)
        vpThemes.setItemTransformer(
                ScaleTransformer.Builder()
                        .setMaxScale(.95f)
                        .setMinScale(0.8f)
                        .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                        .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                        .build()
        )

        /*vpThemes.addOnItemChangedListener { viewHolder, adapterPosition ->
            indicatorView.setCurrentPosition(adapterPosition)
            indicatorView.notifyDataChanged()
        }*/

        indicatorView.apply {
            setSliderColor(Color.RED, Color.GREEN)
            setSliderWidth(200f)
            setSliderHeight(50f)
            setSliderGap(50f)
            setSlideMode(IndicatorSlideMode.COLOR)
            setIndicatorStyle(IndicatorStyle.DASH)
            indicatorView.setPageSize(list.size)
            setupWithScrollView(vpThemes)
        }
    }
}