package com.capstone.voicepix.TextToImage

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capstone.voicepix.ApiCallBack
import com.capstone.voicepix.Model.TextToImageResponse
import com.capstone.voicepix.Retrofit.ApiService
import com.capstone.voicepix.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TextToImageViewmodel : ViewModel() {
    private val _response = MutableLiveData<TextToImageResponse>()
    private var callback: ApiCallBack? = null

    val response: LiveData<TextToImageResponse>
        get() = _response

    private val apiKey = "561eb184-5436-4b26-95b2-27b27e79ff94"

    fun setCallback(apiCallback: ApiCallBack?) {
        callback = apiCallback
    }

    fun getTextToImage(text: String) {
        val call = RetrofitClient.apiService.getTextToImage(text, apiKey)
        call.enqueue(object : Callback<TextToImageResponse> {
            override fun onResponse(call: Call<TextToImageResponse>, response: Response<TextToImageResponse>) {
                if (response.isSuccessful) {
                    _response.value = response.body()

                } else {
                    val errorMessage = "API request failed: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<TextToImageResponse>, t: Throwable) {
                val errorMessage = "Network request failed: ${t.message}"
                callback?.onApiFailure(errorMessage)
            }

        })
    }
}
