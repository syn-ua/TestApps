package com.test.testapp.modules.mock

import com.test.testapp.interfaces.modules.ApiModule
import java.util.*
import javax.inject.Inject

class MockApiModule @Inject constructor() : ApiModule {
    override suspend fun getStreamsAddresses(): List<String> {
//        return Arrays.asList("https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4")
//        return Arrays.asList("http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8")
        return Arrays.asList("https://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8")
    }
}