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
import com.example.ui.fragment.SettingFragment
import com.example.ui.fragment.chart.CartFragment
import com.example.ui.fragment.favorite.FavoriteFragment
import com.example.ui.fragment.favorite.FavoriteViewModel


class MeFragment : Fragment() {
    lateinit var binding: FragmentMeBinding
    lateinit var proudectFragment: SignInFragment
    lateinit var favFragment:FavoriteFragment
    lateinit var  cartFragment : CartFragment
    lateinit var  settingFragment : SettingFragment

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
        click()

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
    fun click(){
        binding.toFav.setOnClickListener {
            favFragment= FavoriteFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, favFragment)?.commit()
        }
        binding.toCart.setOnClickListener{
            cartFragment = CartFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, cartFragment)?.commit()
        }
        binding.toSettings.setOnClickListener {
            settingFragment = SettingFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, settingFragment)?.commit()
        }

    }




}