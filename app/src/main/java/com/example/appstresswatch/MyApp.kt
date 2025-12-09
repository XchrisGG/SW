package com.example.appstresswatch

import android.app.Application
import com.example.appstresswatch.session.SessionManager

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SessionManager.init(this)
    }
}