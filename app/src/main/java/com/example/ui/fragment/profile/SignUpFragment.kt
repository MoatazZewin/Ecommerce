
package com.example.ui.fragment.profile

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentSignUpBinding
import com.example.model.dataClass.customer.Customer
import com.example.model.dataClass.customer.CustomerModel


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var firstName: String
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var userConfirmPassword: String

    /*
    private val viewModel by lazy {
        SignupViewModelFragment.create(this)
    }*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        return binding.root


    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
 binding.tvSignin.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }
        bindUi()
        binding.registerBtn.setOnClickListener {
            if (validateForm()) {

                val customer = CustomerModel(
                    Customer(
                        firstName = firstName,
                        lastName = userPassword,
                        email = userEmail,
                        password = userPassword,
                        passwordConfirmation = userConfirmPassword
                    )
                )
                viewModel.postData(customer)
                viewModel.signupSuccess.observe(viewLifecycleOwner) {
                    if (it!!) {
                        Toast.makeText(
                            requireContext(),
                            "Registered ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else To
                    ast.makeText(
                        requireContext(),
                        "Failed to  Register",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun validateForm(): Boolean {
        firstName = binding.editTextFullName.text.toString()
        userEmail = binding.emailEdt.text.toString()
        userPassword = binding.passwordEdt.text.toString()
        userConfirmPassword = binding.confirmPasswordEdt.text.toString()

        if (firstName.isEmpty()) {
            binding.nameEdt.requestFocus()
            binding.nameEdt.error = "User Name is Required"
            return false
        }

        if (userEmail.isEmpty()) {
            binding.emailEdt.requestFocus()
            binding.emailEdt.error = "Email Address is Required"
            return false
        }

        if (userPassword.isEmpty()) {
            binding.passwordEdt.requestFocus()
            binding.passwordEdt.error = "Password is Required"
            return false
        }
        if (userConfirmPassword.isEmpty()) {
            binding.confirmPasswordEdt.requestFocus()
            binding.confirmPasswordEdt.error = "Confirm Password is Required"
            return false
        }
        if (userPassword != userConfirmPassword) {
            binding.confirmPasswordEdt.requestFocus()
            binding.confirmPasswordEdt.error = "Password Does Not Match Confirm Password"
            return false
        }
        return true
    }

    }*/
    }
}