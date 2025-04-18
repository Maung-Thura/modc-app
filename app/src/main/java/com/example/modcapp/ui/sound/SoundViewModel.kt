package com.example.modcapp.ui.sound

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SoundViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "အသံ (Audio)"
    }
    val text: LiveData<String> = _text
}