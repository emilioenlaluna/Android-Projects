package wep.app.emilioenlaluna.databinding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import wep.app.emilioenlaluna.databinding.databinding.ItemUserBinding
import wep.app.emilioenlaluna.databinding.model.User


class UserAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                binding.tvName.text = this.name
                binding.tvAddress.text = this.address
                binding.root.setOnClickListener {
                    val output = """
                        Hi, My name is ${this.name}
                        I live on ${this.address}
                    """.trimIndent()
                    Toast.makeText(binding.root.context, output, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount() = userList.size

    fun addAll(it: List<User>) = userList.addAll(it)
}