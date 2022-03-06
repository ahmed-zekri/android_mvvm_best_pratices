package com.example.android_mvvm_best_pratices.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_mvvm_best_pratices.TAB_COUNT
import com.example.android_mvvm_best_pratices.presentation.login.LoginFragment
import com.example.android_mvvm_best_pratices.presentation.register.RegisterFragment


class PageAdapter(manager: FragmentActivity) :
    FragmentStateAdapter(manager) {
    override fun getItemCount(): Int = TAB_COUNT


    override fun createFragment(position: Int): Fragment =
        if (position == 0) LoginFragment() else RegisterFragment()


}