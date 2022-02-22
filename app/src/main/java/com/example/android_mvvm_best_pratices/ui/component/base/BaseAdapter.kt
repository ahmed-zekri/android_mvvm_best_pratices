package com.example.android_mvvm_best_pratices.ui.component.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<BINDING : ViewDataBinding, T : AdapterListItem>(val data: List<T>) :
    RecyclerView.Adapter<BaseViewHolder<BINDING>>() {

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<BINDING>, position: Int) {

    }


}

class BaseViewHolder<BINDING : ViewDataBinding>(binder: BINDING) :
    RecyclerView.ViewHolder(binder.root)

interface AdapterListItem {
    val id: Long
}


