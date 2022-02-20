package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.register


import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.databinding.FragmentRegisterBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.activity.AuthenticationActivity
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment() {
    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()


    override fun observeViewModel() {
        viewModel.registerStatus.observe(this.viewLifecycleOwner) {
            if (it.data != null) {
                val tabLayout: TabLayout =
                    (requireActivity() as AuthenticationActivity).binding.tabLayout
                tabLayout.selectTab(tabLayout.getTabAt(0))

            }
        }
    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root

    }


}