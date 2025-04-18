package com.example.modcapp.ui.home

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mmcalendar.Language
import mmcalendar.LanguageTranslator
import mmcalendar.MyanmarDate
import java.util.Locale

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val calendar = Calendar.getInstance()

        // Get Myanmar Date by year, month and day
        val myanmarDate = MyanmarDate.of(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        val stringBuilder = StringBuilder()
        val monthDate = SimpleDateFormat("MMMM", Locale.getDefault())
        val monthName: String = monthDate.format(calendar.time)
        value = myanmarDate.format("S s k, B y k, M p f r En။ ") + stringBuilder.append(
            LanguageTranslator.translateSentence(
                calendar.get(Calendar.DAY_OF_MONTH)
                    .toString() + " " + monthName + " " + calendar.get(Calendar.YEAR),
                Language.ENGLISH,
                Language.MYANMAR
            )
        )
    }
    val text: LiveData<String> = _text
}