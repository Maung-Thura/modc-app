package com.example.modcapp.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "တရားစာအုပ် (Dhamma Books)"
    }
    val text: LiveData<String> = _text
}