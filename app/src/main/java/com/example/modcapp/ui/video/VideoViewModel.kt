package com.example.modcapp.ui.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ဗီဒီယို (Video)"
    }
    val text: LiveData<String> = _text
}