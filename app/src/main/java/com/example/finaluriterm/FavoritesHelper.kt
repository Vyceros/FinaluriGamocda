package com.example.finaluriterm

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FavoritesHelper(context: Context) {

    // Shared prefs
    private var sharedPrefs = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)

    // Gson
    private var gson = Gson()


    fun saveItems(savedItems:ArrayList<Filmebi>){
        val editor = sharedPrefs.edit()
        editor.putString("favoriteItems",gson.toJson(savedItems))
        editor.apply()
    }

    fun getSavedItems() : ArrayList<Filmebi> {
        val savedItems = sharedPrefs.getString("favoriteItems", null)
        val t = object : TypeToken<ArrayList<Filmebi>>() {}.type
        return gson.fromJson(savedItems, t) ?: ArrayList()
    }
}