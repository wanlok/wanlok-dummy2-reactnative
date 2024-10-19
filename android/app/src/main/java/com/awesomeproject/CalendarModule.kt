package com.awesomeproject
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class CalendarModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val tag = "CalendarModule"

    override fun getName(): String {
        return "CalendarModule"
    }

    @ReactMethod
    fun createCalendarEvent(name: String, location: String) {
        Log.d(tag, "Create event called with name: $name and location: $location")
    }
}