package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.fragments.EmbeddedMessageFragment
import com.iterable.iterableapi.IterableApi
import org.json.JSONObject
import com.iterable.iterableapi.IterableEmbeddedUpdateHandler


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EmbeddedMessageFragment())
            .commit()

        // Update Profile Button
        val updateProfileButton = findViewById<Button>(R.id.updateProfileButton)
        updateProfileButton.setOnClickListener {
            val userProfile = JSONObject().apply {
                put("firstName", "Dwayne")
                put("isRegisteredUser", true)
                put("TC_User_Test_Key", "completed")
            }

            // Update the user profile
            IterableApi.getInstance().updateUser(userProfile)
        }

        // Send Custom Event Button
        val sendEventButton = findViewById<Button>(R.id.sendEventButton)
        sendEventButton.setOnClickListener {
            val eventData = JSONObject().apply {
                put("platform", "Android")
                put("isTestEvent", true)
                put("url", "https://iterable.com/sa-test/Dwayne")
                put("secret_code_key", "Code_123")
            }

            // Log a custom event
            IterableApi.getInstance().track("mobileTCTestEvent", eventData)
        }

    }
}
