package com.example.social

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreatePost : AppCompatActivity() {
    lateinit var addpost:Button
    lateinit var textpost:EditText
    private lateinit var postDao:PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        addpost=findViewById(R.id.addpost)
        textpost=findViewById(R.id.posttext)
        postDao=PostDao()
        addpost.setOnClickListener {
            val input=textpost.text.toString().trim()
            if(input.isNotEmpty()){
                postDao.add(input)
                finish()
            }
        }

    }
}