package com.example.myhomework9.Homework2

import android.content.Context
import android.content.SharedPreferences


object MySharedPreference {
    private const val Name = "Name"
    private const val Mode = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(Name, Mode)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var myColor: Boolean
        set(value) = preferences.edit() {
            it.putBoolean("myColor", value)
        }
        get() = preferences.getBoolean("myColor", false)


}