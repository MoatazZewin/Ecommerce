package com.example.ui.fragment.checkout

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentCheckoutBinding

import com.example.ui.fragment.profile.SharedPreferencesProvider
import com.example.ui.repository.Repository
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.paypal.android.sdk.payments.PayPalConfiguration
import com.paypal.android.sdk.payments.PayPalPayment
import com.paypal.android.sdk.payments.PayPalService
import com.paypal.android.sdk.payments.PaymentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal
import kotlin.random.Random

const val CLIENT_ID =
    "AZRTYuZe0rIEPjSwCpMuL0zErHmInW5z5x3WoM4FOPFhwxprMyzagz36HTzVQQ-u8yMIXjH6RBLDS1j8"

class Checkout : Fragment() {
    private lateinit var binding: FragmentCheckoutBinding

    //    private val args: CheckoutArgs by navArgs()
    private lateinit var viewModel: CheckoutViewModel
    private lateinit var config: PayPalConfiguration
    private lateinit var sharedPref: SharedPreferencesProvider


//    private val vm by lazy {
//        CheckOuttViewModel.create(this)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_checkout, container, false)
//        val repository = Repository(RoomData(requireContext()))
//        val checkoutViewModelProviderFactory =
//            CheckoutViewModelFactory(requireActivity().application, repository)
//        viewModel =
//            ViewModelProvider(this, checkoutViewModelProviderFactory)[CheckoutViewModel::class.java]
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = SharedPreferencesProvider(requireActivity())

//        bindArgs()
        bindUI()
        bindPaypal()

    }

    private fun bindPaypal() {
        config = PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(CLIENT_ID)
        var i = Intent(requireActivity(), PayPalService::class.java)
        i.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        requireActivity().startService(i)
    }

    override fun onDestroy() {
        requireActivity().stopService(Intent(requireActivity(), PayPalService::class.java))
        super.onDestroy()
    }
//
//    private fun bindArgs() {
//        val totalPrice = args.totalPrice
//        binding.tvTotalPrice.text = totalPrice
//        binding.tvSubtotal.text = totalPrice
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun bindUI() {
        val orderId = Random.nextLong(1000000, 10000000)
//        val address = sharedPref.getAddress()
//
//        binding.tvCustomerAddress.text = customerAddress
//        binding.tvCustomerName.text = customerName
//        binding.tvCustomerPhone.text = customerPhone
        var paymentMethod: String? = null
//        val totalPrice = binding.tvTotalPrice.text.toString()
//
//        var lineItem: MutableList<LineItem> = arrayListOf()
        val id = 7604694319335

//        lineItem.add(LineItem(1, id.toInt()))


        binding.btnOrder.setOnClickListener {
            val rbSelectedId = binding.rgGroup.checkedRadioButtonId
            val btn = requireView().findViewById<RadioButton>(rbSelectedId)
            if (btn != null) {
                paymentMethod = btn.text.toString()
            }

            when (paymentMethod) {
                "cash" -> {
                    MaterialAlertDialogBuilder(requireActivity())
                        .setTitle(getString(R.string.currency))
                        .setMessage("con order")
                        .setPositiveButton(getString(R.string.ok)) { _, _ ->
                            Toast.makeText(
                                requireActivity(),
                                "getString(R.string.confirmed)",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            CoroutineScope(Dispatchers.IO).launch {
//                                viewModel.addOrder(
//                                    OrderData(
//                                        orderId,
//                                        sharedPref.getUserInfo().customer?.customerId,
//                                        totalPrice,
//                                        customerName,
//                                        customerAddress!!,
//                                        customerPhone!!,
//                                        paymentMethod!!,
//                                        "ACTIVE"
//                                    )
//                                )

                            }
                        }
                        .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                            Toast.makeText(
                                requireActivity(),
                                "getStrin",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }.show()


                }
                "getString(R.string.pay_with_paypal)" -> {
//                    val totalPaypal = totalPrice.toDouble() / 15.7
//                    var payment = PayPalPayment(
//                        BigDecimal.valueOf(totalPaypal),
//                        "USD",
//                        "Checkout",
//                        PayPalPayment.PAYMENT_INTENT_SALE
//                    )
//                    val intent = Intent(requireActivity(), PaymentActivity::class.java)
//                    intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
//                    intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment)
//                    requireActivity().startActivityForResult(intent, 123)
                }
                else -> {
                }

            }

        }

//        binding.btnOrderRepo.setOnClickListener {
//            val order =
//                Order(
////                    billing_address = null,
////                    discount_codes =null ,
//                    email = sharedPref.getUserInfo().customer?.email.toString(),
//                    financial_status = "cash",
//                    line_items = lineItem,
//                    phone = sharedPref.getUserInfo().customer?.phone.toString()
////                    shipping_address = ,
////                    transactions =
//
//
//                )
//
//            vm.postOrder(order)
//            vm.orderSuccess.observe(viewLifecycleOwner) {
//                if (it == true) {
//                    Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_LONG).show()
////                    findNavController().navigate(R.id.signInFragment)
//                } else Toast.makeText(requireContext(), "Try again", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        binding.ivBack.setOnClickListener { findNavController().popBackStack() }
//
//        binding.tvChangeAddress.setOnClickListener {
//            findNavController().navigate(R.id.action_checkout_to_selectAddress)
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(
                    requireActivity(),
                    "getString(R.string.operation_done)",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}