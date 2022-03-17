package com.example.ui.fragment.profile

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.example.model.dataClass.customer.Customer
import com.google.gson.Gson

class SharedPreferencesProvider(context: Context) {
    companion object {
        private lateinit var pref: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor
        private const val PREF_NAME = "myPref"


        private const val IS_SIGN_IN = "IS_SIGN_IN"


        // user Info
        private const val PHONE = "PHONE"
        private const val NAME = "NAME"


    }

    init {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    private val preferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
    }

    val settings: MutableLiveData<CustomerInfo> by lazy {
        MutableLiveData<CustomerInfo>().apply {
            postValue(CustomerInfo.getDefault())
        }
    }






    fun setUserInfo(//userAddress: String?,
        phone: String?, name: String?
    ) {
//        editor.putString(USER_ADDRESS, userAddress)
        editor.putString(PHONE, phone)
        editor.putString(NAME, name)
        editor.commit()
    }

    val getUserInfo: Array<String?>
        get() {
            val info = arrayOfNulls<String>(2)
            val phone = pref.getString(PHONE, "Phone")
            val name = pref.getString(NAME, "Username")
            info[0] = phone
            info[1] = name
            return info
        }




    private fun settingsToJson(settings: CustomerInfo): String {
        val json = Gson()
        return json.toJson(settings)
    }

    private fun settingsFromJson(settings: String): CustomerInfo {
        val json = Gson()
        return json.fromJson(settings, CustomerInfo::class.java)
    }

    fun update(update: (CustomerInfo) -> CustomerInfo) {
        preferences.edit {
            putString(
                Constant.ALL_DATA_ROUTE,
                settingsToJson(update(settings.value ?: CustomerInfo.getDefault()))
            )
            apply()
        }
    }

    fun getSettings(): CustomerInfo {
        return preferences.getString(Constant.ALL_DATA_ROUTE, null)?.let { settingsFromJson(it) }
            ?: CustomerInfo.getDefault()
    }
    fun checkSignIn(isSignIn: Boolean) {
        editor.putBoolean(IS_SIGN_IN, isSignIn)
        editor.commit()
    }

    val isSignIn: Boolean
        get() = pref.getBoolean(IS_SIGN_IN, false)
}

data class CustomerInfo(var customer: Customer?) {
    companion object {
        fun getDefault(): CustomerInfo = CustomerInfo(null)
    }
}