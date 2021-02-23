package com.test.testapp.interfaces.modules

interface ApiModule {
    suspend fun getStreamsAddresses(): List<String>
}