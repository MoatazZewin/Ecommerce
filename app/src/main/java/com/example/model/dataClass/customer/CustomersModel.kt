package com.example.model.dataClass.customer

import com.google.gson.annotations.SerializedName

data class CustomersModel(@SerializedName( "customers")
                          val customer: List<Customer?>,

                          @SerializedName( "error")
                          val error: Error? = null,)
