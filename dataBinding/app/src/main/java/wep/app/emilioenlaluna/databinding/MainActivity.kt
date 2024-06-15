package wep.app.emilioenlaluna.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import wep.app.emilioenlaluna.databinding.adapter.UserAdapter
import wep.app.emilioenlaluna.databinding.databinding.ActivityMainBinding
import wep.app.emilioenlaluna.databinding.model.User


class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupUI()
    }

    private fun setupUI() {
        adapter = UserAdapter(arrayListOf())
        _binding.rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
        _binding.rvUser.adapter = adapter
        renderList()
    }

    private fun renderList() = adapter.addAll(userList())

    private fun userList(): List<User> {
        return listOf(
            User(1, "Fer", "Japan Desa Mammalian RT/RW. 005/002"),
            User(1, "Irawan", "Jalan Desa Pamalian RT/RW. 003/002"),
            User(1, "Sunardy", "Jalan Desa Pamalian RT/RW. 002/001"),
            User(1, "Rahmat", "Jalan Desa Pamalian RT/RW. 005/002"),
            User(1, "Saleh", "Jalan Desa Pamalian RT/RW. 003/002"),
        )
    }
}