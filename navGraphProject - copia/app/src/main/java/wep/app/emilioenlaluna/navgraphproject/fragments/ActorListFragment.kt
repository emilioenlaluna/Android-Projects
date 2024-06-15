package wep.app.emilioenlaluna.navgraphproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import wep.app.emilioenlaluna.navgraphproject.R
import wep.app.emilioenlaluna.navgraphproject.adapters.PhotoAdapter

class ActorListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actor_list, container, false)

        val actorListContainer = view.findViewById<LinearLayout>(R.id.actorListContainer)

        val actorPhotos = getActorPhotos()
        for (photoUrl in actorPhotos) {
            val photoView = inflater.inflate(R.layout.item_photo, actorListContainer, false)
            val imageView = photoView.findViewById<ImageView>(R.id.imageView)
            Picasso.get().load(photoUrl).into(imageView)
            actorListContainer.addView(photoView)
        }

        return view
    }

    private fun getActorPhotos(): List<String> {
        return listOf(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROv2OwSFzCMYjBn2hiD40EADv28JMtu0ZKKA&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuAcsx5kPEwWTOSzonp-wILnHetjDyPUnUTQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZAu609H_qhp5R9x4dySMereomLX2b6cCUOg&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDDZW0Vf0l1bJlwI9OsTpoXMiM7C3zNnU1mQ&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTK0VyKRzYUTWomvrJ11OZGwlmKxWu0lgvag&s"
        )
    }
}
