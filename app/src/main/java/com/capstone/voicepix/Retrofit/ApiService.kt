package com.capstone.voicepix.Retrofit

import com.capstone.voicepix.Model.TextToImageResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("text2img")
    @FormUrlEncoded
    fun getTextToImage(@Field("text") text: String, @Header("api-key") apiKey: String): Call<TextToImageResponse>
}
