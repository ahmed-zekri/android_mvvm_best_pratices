package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.logout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.databinding.FragmentSlideshowBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.activity.AuthenticationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogOutFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: LogOutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        viewModel.logOut()
        viewModel.sharedPrefsCleared.observe(viewLifecycleOwner) {
            if (it)
                goToLogin()


        }
        return binding.root
    }

    private fun goToLogin() {
        requireActivity().finish()
        startActivity(Intent(context, AuthenticationActivity::class.java))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}