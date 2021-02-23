package com.test.testapp.modules.retrofit

import retrofit2.http.*

interface MainRetrofitApi {

    @GET("")
    suspend fun getRoutes(@Header("Authorization") token: String)
}