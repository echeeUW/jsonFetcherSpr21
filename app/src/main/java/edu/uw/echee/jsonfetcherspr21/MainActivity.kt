package edu.uw.echee.jsonfetcherspr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.jsonfetcherspr21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnFetchJson.setOnClickListener {}

        }
    }
}


