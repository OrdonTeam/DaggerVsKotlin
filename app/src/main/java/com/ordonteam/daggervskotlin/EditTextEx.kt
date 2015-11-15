package com.ordonteam.daggervskotlin

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


fun EditText.addOnTextChangedListener(onQueryChanged: (String) -> Any) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            onQueryChanged(s.toString())
        }

        override fun afterTextChanged(s: Editable) {
        }
    })
}