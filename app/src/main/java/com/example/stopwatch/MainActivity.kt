package com.example.stopwatch

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stopwatch.databinding.ActivityMainBinding
import com.example.stopwatch.ui.theme.StopWatchTheme
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private var isRunning = false

    private var timer: Timer? = null
    private var time = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener(this)
        binding.btnRefresh.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_start -> {
                if(isRunning){
                    pause()
                }else {
                    start()
                }
            }
            R.id.btn_refresh -> {
                refressh()
            }
        }
    }
    private fun start(){
        binding.btnStart.text = getString(R.string.btn_pause)
        binding.btnStart.setBackgroundColor(getColor(R.color.btn_pause))
        isRunning = true

        timer = timer(period = 10){
            time++

            val milli_second = time%100
            val second = (time % 6000) / 100
            val minute = time % 6000

            binding.tvMillisecond.text = if(milli_second < 10 ) ".0${milli_second}" else ".${milli_second}"
            binding.tvSecond.text = if(second < 10) ".0${second}" else ":${second}"
            binding.tvMinute.text = "${minute}"
        }
    }

    private fun pause(){

    }

    private fun refressh(){
        
    }
}
