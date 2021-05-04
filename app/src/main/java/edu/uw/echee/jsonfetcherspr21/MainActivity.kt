package edu.uw.echee.jsonfetcherspr21

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import edu.uw.echee.jsonfetcherspr21.databinding.ActivityMainBinding
import edu.uw.echee.jsonfetcherspr21.model.Inbox
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnFetchJson.setOnClickListener {
                fetchInboxWithGson()
            }

            btnClear.setOnClickListener {
                log("Received click")
                tvOutput.text = "This is a reset of code"
            }

        }
    }

    private fun fetchInboxWithGson() {

        val task = Runnable {
            // Fetch json string from URL - fetching manually on Background thread
            val emailsJsonString = URL("https://raw.githubusercontent.com/echeeUW/codesnippets/master/emails.json").readText()

            // Take JsonString response and convert it to our model class Inbox
            val inbox: Inbox = gson.fromJson(emailsJsonString, Inbox::class.java)

            // Switch back to main thread to show data on UI
            runOnUiThread {
                binding.tvOutput.text = inbox.toString()
            }

            log("Inbox Title is: ${inbox.title} and the object it created: $inbox")
        }

        // Create + Launch Background thread task
        val backgroundThread = Thread(task)
        backgroundThread.start()
    }

    /**
     * Helper function for simple logging
     */
    private fun log(msg: String) = Log.i("MainActivity", msg)

//    private fun fakeDelayOnBackgroundThread() {
//        val task = Runnable {
//            fakeNetworkDelay()
//            fetchInboxWithGson()
//        }
//
//        val backgroundThread = Thread(task)
//        backgroundThread.start()
//
//    }
//
//    private fun fakeNetworkDelay() {
//        repeat(5) { count ->
//            log("Delay: $count")
//            Thread.sleep(1000) // don't ever do this in production
//        }
//    }


}


