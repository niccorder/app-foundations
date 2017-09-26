package me.niccorder.foundation.view

import android.text.Editable
import android.view.View
import android.widget.TextView
import me.niccorder.foundation.view.listeners.AfterTextChangedListener
import me.niccorder.foundation.view.listeners.BeforeTextChangedListener
import me.niccorder.foundation.view.listeners.OnTextChangedListener

fun View.visible() { visibility = View.VISIBLE}
fun View.invisible() { visibility = View.INVISIBLE }
fun View.gone() { visibility = View.GONE }

fun View.isVisible(): Boolean { return visibility == View.VISIBLE }
fun View.isGone(): Boolean { return visibility == View.GONE }
fun View.isInvisible(): Boolean { return visibility == View.INVISIBLE }

fun View.onClick(onClick: () -> Unit) = setOnClickListener { onClick.invoke() }

fun TextView.addOnTextChangedListener(
        onTextChange: (String?, Int, Int, Int) -> Unit
) = addTextChangedListener(OnTextChangedListener(onTextChange))

fun TextView.addBeforeTextChangedListener(
        beforeTextChanged: (String?, Int, Int, Int) -> Unit
) = addTextChangedListener(BeforeTextChangedListener(beforeTextChanged))

fun TextView.addAfterTextChangedListener(
        afterTextChanged: (Editable?) -> Unit
) = addTextChangedListener(AfterTextChangedListener(afterTextChanged))