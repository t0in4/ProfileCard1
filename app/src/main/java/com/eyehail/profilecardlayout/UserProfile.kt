package com.eyehail.profilecardlayout

data class UserProfile(val name: String, val status: Boolean, val drawableId: Int)


val userProfileList = arrayListOf<UserProfile>(

    UserProfile(name = "John Doe", status = true, R.drawable.dragon),

    UserProfile(name = "Anna Right", status = false, R.drawable.fox),
    UserProfile(name = "John Doe", status = true, R.drawable.dragon),

    UserProfile(name = "Anna Right", status = false, R.drawable.fox),
    UserProfile(name = "John Doe", status = true, R.drawable.dragon),

    UserProfile(name = "Anna Right", status = false, R.drawable.fox),
    UserProfile(name = "John Doe", status = true, R.drawable.dragon),

    UserProfile(name = "Anna Right", status = false, R.drawable.fox),
)