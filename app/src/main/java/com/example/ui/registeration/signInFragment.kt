/*
package com.example.ui.registeration

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentSignInBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

*/
/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 *//*

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var userEmail: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root


    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  binding.tvSignup.setOnClickListener {
          //  findNavController().navigate(R.id.signUpFragment)
        }


//        bindUi()
        val viewModel by lazy {
            SignInViewModel.create(this)
        }


        binding.loginBtn.setOnClickListener {
            if (validteForm()) {
                Log.d("email", "" + userEmail)
                viewModel.getData(userEmail)
                viewModel.loginSuccess.observe(viewLifecycleOwner) {
                    if (it!!) {
                        //Toast.makeText(requireContext(), "You entered your mail ", Toast.LENGTH_LONG).show()
                      //  findNavController().navigate(R.id.signInPasswordFragment)
                    }
                }
            }
        }

    }

    private fun validteForm(): Boolean {
        userEmail = binding.emailEdt.text.toString()
        if (userEmail.isEmpty()) {
            binding.emailEdt.requestFocus()
            binding.emailEdt.error = "Required"
            return false
        }
        return true

    }

}*/
