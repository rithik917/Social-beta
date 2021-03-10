package com.example.social

import com.example.social.models.User

data class Post (
    val text:String="",
    val createdBy: User=User(),
val createdAt:Long=0L,
    val likedby: ArrayList<String> = ArrayList())

