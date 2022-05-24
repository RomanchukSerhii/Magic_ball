package com.serhii_romanchuk.a8ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.serhii_romanchuk.a8ball.databinding.ActivityMainBinding
import kotlin.properties.Delegates.notNull

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var answer by notNull<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.answerTextView.text = savedInstanceState?.getString(KEY_ANSWER) ?: ""
        binding.askMeButton.setOnClickListener {
            onAskMePressed()
        }
    }

    fun onAskMePressed() {
        answer = Answer().getAnswer()
        binding.answerTextView.text = answer
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_ANSWER, answer)
    }

    companion object {
        const val KEY_ANSWER = "KEY_ANSWER"
    }
}