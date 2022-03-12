package com.example.model.dataClass.customer

import com.google.gson.annotations.SerializedName

data class CustomerModel(@SerializedName( "customer")
                         val customer: Customer?,

                         @SerializedName( "error")
                         val error: Error? = null,)
