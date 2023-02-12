package com.example.myhomework9.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.myhomework9.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object MySharedPreference {

    private const val Name = "Storage"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(Name, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var catchList: ArrayList<User>
        get() = gsonStringToArrayList(preferences.getString("keyList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("keyList", arrayListToGsonString(value))
        }


    private fun arrayListToGsonString(list: ArrayList<User>): String {
        val gson = Gson()
        return gson.toJson(list)
    }


    private fun gsonStringToArrayList(str: String): ArrayList<User> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<User>>() {}.type
        return gson.fromJson<ArrayList<User>>(str, type)
    }
}