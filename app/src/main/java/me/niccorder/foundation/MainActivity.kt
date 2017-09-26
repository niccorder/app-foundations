package me.niccorder.foundation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity
import me.niccorder.foundation.inject2.PerActivity
import javax.inject.Inject

@Module
@PerActivity
class MainModule {

    @Provides
    @PerActivity
    fun handler(): Handler = Handler(Looper.getMainLooper())
}

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val KEY_COUNT = "key_count"
    }

    @Inject lateinit var mainHandler: Handler

    private lateinit var timerText: TextView
    private var count = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count = savedInstanceState?.getInt(KEY_COUNT) ?: 0

        timerText = findViewById(R.id.timer_text)
        timerText.text = "counter: $count"
    }

    override fun onStart() {
        super.onStart()
        incrementCounter()
    }

    @SuppressLint("SetTextI18n")
    private fun incrementCounter() {
        timerText.text = "counter: ${++count}"
        mainHandler.postDelayed({ incrementCounter() }, 1000)
    }

    override fun onStop() {
        super.onStop()

        mainHandler.removeCallbacksAndMessages(null)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putInt(KEY_COUNT, count)
    }
}