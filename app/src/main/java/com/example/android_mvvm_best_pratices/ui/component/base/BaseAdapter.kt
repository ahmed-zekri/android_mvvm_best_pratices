package com.example.android_mvvm_best_pratices.ui.component.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<BINDING : ViewDataBinding, T : AdapterListItem>(var data: List<T>) :
    RecyclerView.Adapter<BaseViewHolder<BINDING>>() {
    @get:LayoutRes
    abstract val layoutId: Int

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: BaseViewHolder<BINDING>, position: Int) {

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDate(data: List<T>) {
        this.data = data
        notifyDataSetChanged()


    }

    abstract fun bind(binder: BINDING, item: T)
    override fun onBindViewHolder(
        holder: BaseViewHolder<BINDING>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        bind(holder.binder, data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BINDING> {
        val binder = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return BaseViewHolder(binder)
    }

}

class BaseViewHolder<BINDING : ViewDataBinding>(val binder: BINDING) :
    RecyclerView.ViewHolder(binder.root)

interface AdapterListItem {
    val id: Long?
}