package com.example.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.iterable.iterableapi.IterableApi
import com.iterable.iterableapi.IterableEmbeddedManager
import com.iterable.iterableapi.IterableEmbeddedUpdateHandler
import com.iterable.iterableapi.ui.embedded.IterableEmbeddedView
import com.iterable.iterableapi.ui.embedded.IterableEmbeddedViewConfig
import com.iterable.iterableapi.ui.embedded.IterableEmbeddedViewType

class EmbeddedMessageFragment : Fragment(), IterableEmbeddedUpdateHandler {

    private lateinit var embeddedManager: IterableEmbeddedManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        embeddedManager = IterableApi.getInstance().embeddedManager
    }

    override fun onResume() {
        super.onResume()
        embeddedManager.addUpdateListener(this)
        checkAndDisplayMessages()
    }

    override fun onPause() {
        super.onPause()
        embeddedManager.removeUpdateListener(this)
    }

    override fun onMessagesUpdated() {
        checkAndDisplayMessages()
    }

    override fun onEmbeddedMessagingDisabled() {
        view?.findViewById<View>(R.id.placeholder_view)?.visibility = View.GONE
    }

    private fun checkAndDisplayMessages() {
        val messages = embeddedManager.getMessages(12345678910) // Replace with your placement ID
        val container = view?.findViewById<ViewGroup>(R.id.placeholder_view)

        if (messages.isNullOrEmpty()) {
            container?.visibility = View.GONE
        } else {
            val config = IterableEmbeddedViewConfig(
                backgroundColor = Color.parseColor("#FFFFFF"),
                borderColor = Color.parseColor("#000000"),
                borderWidth = 1,
                borderCornerRadius = 8f,
                primaryBtnBackgroundColor = Color.parseColor("#0000FF"),
                primaryBtnTextColor = Color.parseColor("#FFFFFF"),
                secondaryBtnBackgroundColor = Color.parseColor("#FFFFFF"),
                secondaryBtnTextColor = Color.parseColor("#000000"),
                titleTextColor = Color.parseColor("#000000"),
                bodyTextColor = Color.parseColor("#000000")
            )

            val messageView = IterableEmbeddedView(
                IterableEmbeddedViewType.CARD,
                messages.first(),
                config
            )
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            ft.replace(R.id.placeholder_view, messageView)
            ft.commit()
        }
    }
}
