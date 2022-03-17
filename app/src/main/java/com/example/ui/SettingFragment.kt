package com.example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentAboutBinding
import com.example.ecommerce.databinding.FragmentSettingBinding
import com.example.ecommerce.databinding.FragmentWomanBinding
import com.example.ui.fragment.ContactUsFragment
import com.example.ui.fragment.category.WomanFilterFragment
import com.example.ui.fragment.profile.AuthRepo
import com.example.ui.fragment.profile.SharedPreferencesProvider
import com.example.ui.settings.AboutFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    private lateinit var _binding: FragmentSettingBinding
    private  var about=AboutFragment()
    private  var contact=ContactUsFragment()
    private  var auth:AuthRepo?=null
    private var setting :SharedPreferencesProvider?=null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_setting, container, false)
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.aboutUsBtn.setOnClickListener {
            about = AboutFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,about )?.commit()
        }
        _binding!!.contactUSBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,contact )?.commit()

        }
        _binding.signout.setOnClickListener {
           auth!!.sharedPref.update {
               it.copy(
                   customer = null
               )
           }
        }


    }

    }
