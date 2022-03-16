package com.example.ui.fragment.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentConfirmSigninBinding
import com.example.ui.fragment.profile.SignInViewModel.Companion.create
import java.net.URI.create

class ConfirmSinginFragment : Fragment() {
    private lateinit var userPass: String
    lateinit var binding: FragmentConfirmSigninBinding

    private val viewModel by lazy {
        ConfirmSigninViewModel.create(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreate.setOnClickListener {
            userPass = binding.editTextTextPersonName.text.toString()
            Log.d("alaa,moatez,fady,", "" + viewModel.authenticationRepo.sharedPref.getSettings().customer!!.lastName)

            if (viewModel.authenticationRepo.sharedPref.getSettings().customer!!.lastName.equals(userPass)
            ) {
                Toast.makeText(requireContext(), "you logged", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.authenticationRepo.sharedPref.getSettings()
    }
}