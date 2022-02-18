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
import com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login.RegisterViewModel
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment() {
    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    override fun observeViewModel() {
        viewModel.registerStatus.observe(this) {

        }
    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.roles,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                binding.spinner.adapter = adapter

                val typeface = ResourcesCompat.getFont(requireContext(), R.font.font_opensans_light)
                binding.spinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
                    AdapterView.OnItemSelectedListener {
                    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        val textView = p0?.getChildAt(0) as TextView
                        textView.typeface = typeface
                        textView.setTextColor(requireActivity().getColor(R.color.gray))
                        textView.setTypeface(textView.typeface, Typeface.BOLD)


                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }


                }
            }
        }
        return binding.root

    }


}