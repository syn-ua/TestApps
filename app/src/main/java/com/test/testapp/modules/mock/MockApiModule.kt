package com.test.testapp.modules.mock

import com.test.testapp.interfaces.modules.ApiModule
import java.util.*
import javax.inject.Inject

class MockApiModule @Inject constructor() : ApiModule {
    override suspend fun getStreamsAddresses(): List<String> {
        return Arrays.asList("https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4")
    }
}