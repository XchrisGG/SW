package com.example.appstresswatch.session

import android.content.Context
import android.content.SharedPreferences

object SessionManager {

    private const val PREF_NAME = "app_session"
    private const val KEY_USER_ID = "user_id"
    private const val KEY_TOKEN = "token"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    var userId: String?
        get() = prefs.getString(KEY_USER_ID, null)
        set(value) {
            prefs.edit().putString(KEY_USER_ID, value).apply()
        }

    var token: String?
        get() = prefs.getString(KEY_TOKEN, null)
        set(value) {
            prefs.edit().putString(KEY_TOKEN, value).apply()
        }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
