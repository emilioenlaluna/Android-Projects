package wep.app.emilioenlaluna.navgraphproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import wep.app.emilioenlaluna.navgraphproject.R

class CatAdapter(private val catUrls: List<String>) :
    RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        Picasso.get().load(catUrls[position]).into(holder.imageView)
    }

    override fun getItemCount() = catUrls.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
