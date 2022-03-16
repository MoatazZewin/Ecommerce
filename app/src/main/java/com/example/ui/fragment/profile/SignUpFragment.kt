
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
    private lateinit var pass: String



    private val viewModel by lazy {
        SignUpViewModel.create(this)
    }
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

        binding.buttonCreate.setOnClickListener {
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
                    } else
                        Toast.makeText(
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
        userEmail = binding.editTextEmail.text.toString()
        userPassword = binding.editTextPassword.text.toString()
        userConfirmPassword = binding.editTextConfiemPass.text.toString()

        if (userEmail.isEmpty()) {
            binding.editTextEmail.requestFocus()
            binding.editTextEmail.error = "Required"
            return false
        }


        if (firstName.isEmpty()) {
            binding.editTextFullName.requestFocus()
            binding.editTextFullName.error = "Required"
            return false
        }


        if (userPassword.isEmpty()) {
            binding.editTextPassword.requestFocus()
            binding.editTextPassword.error = "Required"
            return false
        }
        if (userConfirmPassword.isEmpty()) {
            binding.textConfirmPass.requestFocus()
            binding.textConfirmPass.error = "Required"
            return false
        }
        if (userPassword != userConfirmPassword) {
            binding.textConfirmPass.requestFocus()
            binding.textConfirmPass.error = "doesn't match the password"
            return false
        }
        return true
    }
}
