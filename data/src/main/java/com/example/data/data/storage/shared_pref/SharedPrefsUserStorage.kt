package com.example.data.data.storage.shared_pref

import android.content.Context
import com.example.data.data.storage.UserStorage
import com.example.data.data.storage.model.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Ivan"
private const val DEFAULT_LAST_NAME = "Ivanov"


class SharedPrefsUserStorage(context: Context) : UserStorage {

    private val sharedPrefsUserStorage =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUser(user: User): Boolean {
        sharedPrefsUserStorage.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPrefsUserStorage.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return user.firstName.isNotEmpty()
    }

    override fun getUser(): User {
        val firstName =
            sharedPrefsUserStorage.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME)
                ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPrefsUserStorage.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName, lastName)
    }
}