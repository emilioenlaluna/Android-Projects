package wep.app.emilioenlaluna.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Toast
import wep.app.emilioenlaluna.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(this@MainActivity, binding.username.text, Toast.LENGTH_LONG).show()
        }
    }
}