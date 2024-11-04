import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var isRunning = false
    private var timeWhenStopped: Long = 0L
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            if (!isRunning) {
                startStopwatch()
                startButton.text = "Pause"
            } else {
                pauseStopwatch()
                startButton.text = "Start"
            }
        }

        clearButton.setOnClickListener {
            if (isRunning) {
                resetStopwatchWhileRunning()
            } else {
                resetStopwatch()
            }
        }
    }

    private fun startStopwatch() {
        isRunning = true
        val baseTime = SystemClock.elapsedRealtime() - timeWhenStopped
        job = lifecycleScope.launch(Dispatchers.Main) {
            while (isRunning) {
                val currentTime = SystemClock.elapsedRealtime() - baseTime
                updateTimerText(currentTime)
                delay(10L) // 10ms마다 갱신
            }
        }
    }

    private fun pauseStopwatch() {
        isRunning = false
        job?.cancel()
        timeWhenStopped = SystemClock.elapsedRealtime() - baseTime
    }

    private fun resetStopwatchWhileRunning() {
        isRunning = false
        job?.cancel()
        timeWhenStopped = 0L
        updateTimerText(0L)
        startStopwatch() // 바로 다시 시작
    }

    private fun resetStopwatch() {
        isRunning = false
        job?.cancel()
        timeWhenStopped = 0L
        updateTimerText(0L)
        startButton.text = "Start"
    }

    private fun updateTimerText(timeInMillis: Long) {
        val seconds = (timeInMillis / 1000) % 60
        val minutes = (timeInMillis / 1000) / 60
        val millis = (timeInMillis % 1000) / 10
        timerTextView.text = String.format("%02d:%02d,%02d", minutes, seconds, millis)
    }
}
