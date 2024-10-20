package com.awesomeproject

import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.ActivityEventListener
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback;

class CustomShare(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext),
    ActivityEventListener {
    private val tag = "CustomShare"

    override fun getName(): String {
        return "CustomShare"
    }

    init {
        reactContext.addActivityEventListener(this)
    }

    companion object {
        const val REFER_REQUEST_CODE = 1622
        const val COPY_BUTTON_CLICK_RESULT_CODE = -1
    }

    private var onCopyButtonClick: Callback? = null

    @ReactMethod
    fun open(text: String, onCopyButtonClick: Callback) {
        val activity = reactContext.currentActivity;
        if (activity != null) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, text)
            this.onCopyButtonClick = onCopyButtonClick
            activity.startActivityForResult(Intent.createChooser(intent, null), REFER_REQUEST_CODE)
        }
    }

    override fun onActivityResult(activity: Activity?, requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REFER_REQUEST_CODE && resultCode == COPY_BUTTON_CLICK_RESULT_CODE) {
            onCopyButtonClick?.invoke()
        }
    }

    override fun onNewIntent(intent: Intent?) {

    }
}