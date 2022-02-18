package com.example.android_mvvm_best_pratices.ui.component.authentication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.android_mvvm_best_pratices.databinding.ViewPagerItemBinding


class PageAdapter(private val mContext: Context, private val itemList: List<String>) :
    PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = ViewPagerItemBinding.inflate(layoutInflater!!, container, false)
        return binding.root
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}