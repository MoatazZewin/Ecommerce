package com.example.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    lateinit var binding: FragmentSignInBinding
    lateinit var meFragment: MeFragment
    lateinit var signUnFragment: SignUpFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()

    }


    fun click() {
        binding.textViewCreate.setOnClickListener {
//            findNavController().navigate(R.id.signUpFragment)
            signUnFragment = SignUpFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, signUnFragment)?.commit()
        }
        binding.leftIconLogin.setOnClickListener {
//            findNavController().navigate(R.id.meFragment)
            meFragment = MeFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, meFragment)?.commit()
        }
    }
}