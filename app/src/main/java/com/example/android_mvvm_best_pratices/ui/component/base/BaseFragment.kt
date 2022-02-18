package com.example.android_mvvm_best_pratices.ui.component.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun observeViewModel()
    protected abstract fun initViewBinding(layoutInflater: LayoutInflater): View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        observeViewModel()
        return initViewBinding(layoutInflater)
    }

}