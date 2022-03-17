package com.example.ui.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentMeBinding
import com.example.ui.fragment.ProductFragment
import com.example.ui.fragment.favorite.FavoriteViewModel


class MeFragment : Fragment() {
    lateinit var binding: FragmentMeBinding
    lateinit var proudectFragment: SignInFragment
    val viewModel by lazy {
        FavoriteViewModel.create(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            proudectFragment = SignInFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, proudectFragment)?.commit()


            }

        if(viewModel.repo.sharedPref.getSettings().customer == null)
        {
            binding.txtName.setText("welcom")
            binding.btnLogin.visibility = View.VISIBLE
        }else
        {
            binding.btnLogin.visibility = View.INVISIBLE
            binding.txtName.setText("hi, "+viewModel.repo.sharedPref.getSettings().customer!!.firstName)
        }
        }




}