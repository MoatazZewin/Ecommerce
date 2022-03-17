package com.example.ui.fragment.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ecommerce.R
import com.example.ecommerce.SearchFragment
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.example.model.dataClass.brand.SmartCollections
import com.example.ui.SettingFragment
import com.example.ui.adapter.AdapterBrand
import com.example.ui.fragment.ProductFragment
import com.example.ui.fragment.Search1Fragment
import com.example.ui.fragment.chart.CartFragment
import com.example.ui.fragment.favorite.FavoriteFragment
import com.example.ui.viewmodel.BrandViewModel

class HomeFragment : Fragment(), AdapterBrand.OnBrandClickListner {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var adapterBrand: AdapterBrand
    lateinit var proudectFragment: ProductFragment
    lateinit var favFragment: FavoriteFragment
    lateinit var cartFragment: CartFragment
    lateinit var settingFragment: SettingFragment
    lateinit var searchFragment1: Search1Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brandViewModel = ViewModelProvider(requireActivity())[BrandViewModel::class.java]
        brandViewModel.liveDataResponse.observe(viewLifecycleOwner, {
            adapterBrand = AdapterBrand(requireContext(), this)
            adapterBrand.addList(it.smartCollections)

            val imageSlider =binding.imageSlider
            val imageList = ArrayList<SlideModel>()

            imageList.add(SlideModel("https://thumbs.dreamstime.com/z/50-discount-25117666.jpg","50%"))
            imageList.add(SlideModel("https://thumbs.dreamstime.com/z/valentines-day-sale-vector-banner-template-discount-text-hearts-elements-white-pattern-background-illustration-137564994.jpg","valantines"))
            imageList.add(SlideModel("https://cdn5.vectorstock.com/i/1000x1000/37/34/hot-sale-vector-3643734.jpg","hot sale"))
            imageList.add(SlideModel("https://img.freepik.com/free-vector/red-sale-price-tag-style-banner-design-template_1017-27328.jpg?size=626&ext=jpg","sale"))

            imageSlider.setImageList(imageList,ScaleTypes.FIT)
            binding.recyclerBrand.adapter = adapterBrand


        })
        click()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)


    }


    override fun onBrandClick(smartCollections: SmartCollections, position: Int) {
        brandViewModel.getProducts(smartCollections.id!!)
        proudectFragment = ProductFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, proudectFragment)?.commit()


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
        binding.leftIconLogin.setOnClickListener {
                searchFragment1 = Search1Fragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, searchFragment1)?.commit()
        }

    }


}