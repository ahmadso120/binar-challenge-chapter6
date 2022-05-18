package com.sopian.challenge5.storage

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String?
    fun remove(key: String)
    fun setBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
}

class SharedPreferencesStorage @Inject constructor(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        sharedPreferences.edit() {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    override fun remove(key: String) {
        sharedPreferences.edit() {
            remove(key)
            apply()
        }
    }

    override fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit() {
            putBoolean(key, value)
            apply()
        }
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}