package edu.uw.echee.jsonfetcherspr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import edu.uw.echee.jsonfetcherspr21.databinding.ActivityMainBinding
import edu.uw.echee.jsonfetcherspr21.model.Email
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnFetchJson.setOnClickListener {
                fetchIndividualEmailWithGson()
            }

        }
    }

    private fun fetchMultipleEmailsJson() {
        // Parse a json manually

        runCatching {
            val emailsJson = JSONObject(emailsJsonString)

            if (emailsJson.has("title")) {
                val title = emailsJson.getString("title")
                Log.i("echee", "Title is: $title")
                binding.tvOutput.text = "Title is: $title"
            }

            if (emailsJson.has("emails")) {
                val emailsArray = emailsJson.getJSONArray("emails")

                for (index in 0 until emailsArray.length()) {
                    val curEmail = emailsArray.getJSONObject(index)
                    Log.i("echee", "curEmail: $curEmail")
                }
            }
        }.onFailure {
            Toast.makeText(this, "Invalid json", Toast.LENGTH_SHORT).show()
        }.onSuccess {
            Log.i("echee", "Valid json")
        }
    }

    private fun fetchIndividualEmailWithGson() {
        val email = gson.fromJson(emailJsonString, Email::class.java)

        val content = email.content

        val lengthOFFrom = email.from.length

        binding.tvOutput.text = "Content: $content"
    }
}

private val emailJsonString = """
    {
        "id": 0,
        "from": "seahawks@gmail.com",
        "content": "Go Hawks!!! SEA!! HAWKSSS!!!! Go 12s! Legion of boom",
        "isImportant": true
    }
""".trimIndent()

private val emailsJsonString = """
    {
        "title": "Mailed It - App",

    	"emails": [
    		{
    			"id": 0,
    			"from": "seahawks@gmail.com",
    			"content": "Go Hawks!!! SEA!! HAWKSSS!!!! Go 12s! Legion of boom",
    			"isImportant": true
    		},
    		{
    			"id": 1,
    			"from": "49ers@hotmail.com",
    			"content": "Let's go Niners!!! Richard Sherman interception! Ay bay bay",
    			"isImportant": false
    		},
    		{
    			"id": 2,
    			"from": "patriots@aol.com",
    			"content": "We like flat footballs and spy cameras",
    			"isImportant": false
    		},
    		{
    			"id": 3,
    			"from": "tony@starkindustries.com",
    			"content": "I am Iron-Man and I love cheeseburgers. I love you 3000",
    			"isImportant": true
    		}
    	]
    }
""".trimIndent()


