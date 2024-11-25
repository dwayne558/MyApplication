package com.example.myapplication


import com.iterable.iterableapi.IterableInAppHandler
import com.iterable.iterableapi.IterableInAppHandler.InAppResponse
import com.iterable.iterableapi.IterableInAppMessage

class MyInAppHandler : IterableInAppHandler {
    override fun onNewInApp(message: IterableInAppMessage): InAppResponse {
        return InAppResponse.SHOW // Always show in-app messages
    }
}