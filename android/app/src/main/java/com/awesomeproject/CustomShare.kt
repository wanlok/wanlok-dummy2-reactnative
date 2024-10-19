package com.awesomeproject

import android.content.Intent
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class CustomShare(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val tag = "CustomShare"

    override fun getName(): String {
        return "CustomShare"
    }

    @ReactMethod
    fun open(text: String) {
        val activity = reactContext.currentActivity;
        if (activity != null) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, text)
            activity?.startActivityForResult(Intent.createChooser(intent, null), 0, null)
        }
    }
}