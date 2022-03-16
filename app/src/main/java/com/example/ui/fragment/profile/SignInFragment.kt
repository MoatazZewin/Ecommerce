package com.example.ui.fragment.profile

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    lateinit var binding: FragmentSignInBinding
    lateinit var meFragment: MeFragment
    lateinit var signUnFragment: SignUpFragment
    private lateinit var userEmail: String
    private lateinit var pass: String
    val viewModel by lazy {
        SignInViewModel.create(this)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()



        binding.buttonCreate.setOnClickListener {
            if (validteForm()) {
                Log.d("email", "" + userEmail)
                viewModel.getData(userEmail, pass)
                viewModel.loginSuccess.observe(viewLifecycleOwner) {
                    if (it!!) {
                        Toast.makeText(requireContext(), "done for email", Toast.LENGTH_LONG)
                            .show()
                        // findNavController().navigate(R.id.)
                    }
                }
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun click() {
        binding.textViewCreate.setOnClickListener {
//            findNavController().navigate(R.id.signUpFragment)
            signUnFragment = SignUpFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, signUnFragment)?.commit()
        }
        binding.leftIconInLogin.setOnClickListener {
//            findNavController().navigate(R.id.homeFragment)
            meFragment = MeFragment()
            signUnFragment = SignUpFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, meFragment)?.commit()
        }
        binding.buttonCreate.setOnClickListener {
            if (validteForm()) {
                Log.d("email", "" + userEmail + "pass" + pass)
                viewModel.getData(userEmail, pass)
                viewModel.loginSuccess.observe(viewLifecycleOwner) {
                    if (it!!) {
                        Toast.makeText(requireContext(), "Successfully Login", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

//        binding.buttonCreate.setOnClickListener{
//            confirmSinginFragment = ConfirmSinginFragment()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.fragment_container, confirmSinginFragment)?.commit()
//        }
    }

    private fun validteForm(): Boolean {
        userEmail = binding.editTextTextPersonName.text.toString()
        pass = binding.etPassword.text.toString()

        if (userEmail.isEmpty()) {
            binding.editTextTextPersonName.requestFocus()
            binding.editTextTextPersonName.error = "Required"
            return false
        }
        if (pass.isEmpty()) {
            binding.etPassword.requestFocus()
            binding.etPassword.error = "Required"
            return false
        }
        return true

    }


}





