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

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        val movieListContainer = view.findViewById<LinearLayout>(R.id.movieListContainer)

        val moviePhotos = getMoviePhotos()
        for (photoUrl in moviePhotos) {
            val photoView = inflater.inflate(R.layout.item_photo, movieListContainer, false)
            val imageView = photoView.findViewById<ImageView>(R.id.imageView)
            Picasso.get().load(photoUrl).into(imageView)
            movieListContainer.addView(photoView)
        }

        return view
    }

    private fun getMoviePhotos(): List<String> {
        return listOf(
            "https://m.media-amazon.com/images/I/51N3gMJVdNL._AC_.jpg",
            "https://m.media-amazon.com/images/I/51yJ5vSJDqL._AC_.jpg",
            "https://m.media-amazon.com/images/I/61kZI1JqEpL._AC_SY679_.jpg",
            "https://m.media-amazon.com/images/I/81o5IfHkGSL._AC_SY679_.jpg",
            "https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg"
        )
    }
}
