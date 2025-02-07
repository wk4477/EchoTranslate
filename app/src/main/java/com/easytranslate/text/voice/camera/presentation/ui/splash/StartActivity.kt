package com.easytranslate.text.voice.camera.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.easytranslate.text.voice.camera.R
import com.easytranslate.text.voice.camera.databinding.ActivityStartBinding
import com.easytranslate.text.voice.camera.presentation.ui.mainactivity.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {

    private var activityJob: Job? = null

    private lateinit var startBinding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding = ActivityStartBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(startBinding.root)
        setClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityJob?.cancel()
    }

    private fun navigateToMainActivity() {
        activityJob = CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun setClick() {
            startBinding.apply {
                getStartedBtn.setOnClickListener {
                    navigateToMainActivity()
                }
            }
    }


}