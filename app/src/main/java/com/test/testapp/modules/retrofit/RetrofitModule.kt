package com.test.testapp.modules.retrofit

import com.test.testapp.BuildConfig
import com.test.testapp.interfaces.modules.ApiModule
import javax.inject.Inject


class RetrofitModule @Inject constructor(
    private val retrofit: RetrofitProvider
) : ApiModule {
    private val TAG = RetrofitModule::class.java.simpleName
    private var api: MainRetrofitApi? = null


    private fun getMainRetrofitApi(): MainRetrofitApi {
        if (api == null) {
            api = retrofit.getRetrofit(BuildConfig.BASE_URL).create(MainRetrofitApi::class.java)
        }
        return api!!
    }

    override suspend fun getStreamsAddresses(): List<String> {
        TODO("Not yet implemented")
    }


}
