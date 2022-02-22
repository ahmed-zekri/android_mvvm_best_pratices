package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.register


import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.data.Resource
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

            if (it is Resource.Loading)
                requireActivity().window.setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                )
            else
                requireActivity().window
                    .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            if (it is Resource.Success) {
                val tabLayout: TabLayout =
                    (requireActivity() as AuthenticationActivity).binding.tabLayout
                tabLayout.selectTab(tabLayout.getTabAt(0))

            }

        }
    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)

        binding.registerViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root

    }


}