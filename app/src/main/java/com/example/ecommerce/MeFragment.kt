package com.example.ecommerce

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class MeFragment : Fragment() {

     lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_me, container, false)
        button = view.findViewById(R.id.btn_login)
        button.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Login::class.java)
            startActivity(intent)
        })
        return view
    }


}