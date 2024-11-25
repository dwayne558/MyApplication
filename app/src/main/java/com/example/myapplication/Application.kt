package com.example.myapplication

import android.app.Application
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.iterable.iterableapi.IterableAction
import com.iterable.iterableapi.IterableActionContext
import com.iterable.iterableapi.IterableApi
import com.iterable.iterableapi.IterableConfig
import com.iterable.iterableapi.IterableCustomActionHandler
import com.iterable.iterableapi.IterableFirebaseMessagingService

class CustomApplication : Application(), IterableCustomActionHandler  {
    override fun onCreate() {
        super.onCreate()

        // Initialize the Iterable SDK
        val  iterableConfig = IterableConfig.Builder()

            .setCustomActionHandler(this)
            .setCustomActionHandler(this)
            .setEnableEmbeddedMessaging(true)
            .setUseInMemoryStorageForInApps(true)
            .setPushIntegrationName("APP") // Optional if using push notifications
            .build()

        IterableApi.initialize( this,"15161afb186b4b56847c4970fed7e5dc", iterableConfig)
        IterableApi.getInstance().setEmail("dwayne558@googlemail.com")
        IterableApi.getInstance().registerForPush()
        IterableApi.getInstance().embeddedManager.syncMessages()
    }
    class MyFirebaseMessagingService : FirebaseMessagingService() {
        override fun onMessageReceived(remoteMessage: RemoteMessage) {
            IterableFirebaseMessagingService.handleMessageReceived(this, remoteMessage)
        }

        override fun onNewToken(s: String) {
            IterableFirebaseMessagingService.handleTokenRefresh()
        }
    }

    override fun handleIterableCustomAction(
        p0: IterableAction,
        p1: IterableActionContext
    ): Boolean {
        TODO("Not yet implemented")
    }

}
