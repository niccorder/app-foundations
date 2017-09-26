package me.niccorder.foundation.view.listeners

import android.text.Editable
import android.text.TextWatcher

open class OnTextChangedListener(
        private val onTextChanged: (String?, Int, Int, Int) -> Unit
) : TextWatcher {
    override fun afterTextChanged(p0: Editable?) = Unit
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    override fun onTextChanged(
            p0: CharSequence?,
            p1: Int,
            p2: Int,
            p3: Int
    ) = onTextChanged.invoke(p0?.toString(), p1, p2, p3)
}

open class AfterTextChangedListener(
        private val afterTextChanged: (Editable?) -> Unit
) : TextWatcher {
    override fun afterTextChanged(p0: Editable?) = afterTextChanged.invoke(p0)
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
}


open class BeforeTextChangedListener(
        private val beforeTextChanged: (String?, Int, Int, Int) -> Unit
) : TextWatcher {
    override fun afterTextChanged(p0: Editable?) = Unit
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    override fun beforeTextChanged(
            p0: CharSequence?,
            p1: Int,
            p2: Int,
            p3: Int
    ) = beforeTextChanged.invoke(p0?.toString(), p1, p2, p3)
}