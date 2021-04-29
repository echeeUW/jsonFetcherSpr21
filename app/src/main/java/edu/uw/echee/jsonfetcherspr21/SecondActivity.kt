package edu.uw.echee.jsonfetcherspr21

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun startSecondActivity(context: Context) = with(context) {
    startActivity(Intent(this, SecondActivity::class.java))
}

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
