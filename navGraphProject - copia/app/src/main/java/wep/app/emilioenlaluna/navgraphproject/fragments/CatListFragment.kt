package wep.app.emilioenlaluna.navgraphproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import wep.app.emilioenlaluna.navgraphproject.R

class CatListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cat_list, container, false)

        val catListContainer = view.findViewById<LinearLayout>(R.id.catListContainer)

        val catPhotos = getCatPhotos()
        for (photoUrl in catPhotos) {
            val photoView = inflater.inflate(R.layout.item_photo, catListContainer, false)
            val imageView = photoView.findViewById<ImageView>(R.id.imageView)
            Picasso.get().load(photoUrl).into(imageView)
            catListContainer.addView(photoView)
        }

        return view
    }

    private fun getCatPhotos(): List<String> {
        return listOf(
            "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg",
            "https://cdn2.thecatapi.com/images/MTY3ODIyMg.jpg",
            "https://cdn2.thecatapi.com/images/MTY3ODIyNA.jpg",
            "https://cdn2.thecatapi.com/images/MTY3ODIyNQ.jpg",
            "https://cdn2.thecatapi.com/images/MTY3ODIyNg.jpg"
        )
    }
}
