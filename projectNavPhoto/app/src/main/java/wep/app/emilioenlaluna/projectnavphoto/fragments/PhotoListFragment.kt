package wep.app.emilioenlaluna.projectnavphoto.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import wep.app.emilioenlaluna.projectnavphoto.R
import wep.app.emilioenlaluna.projectnavphoto.adapter.PhotoAdapter
import wep.app.emilioenlaluna.projectnavphoto.databinding.FragmentPhotoListBinding
import wep.app.emilioenlaluna.projectnavphoto.db.AppDatabase
import wep.app.emilioenlaluna.projectnavphoto.factory.PhotoViewModelFactory
import wep.app.emilioenlaluna.projectnavphoto.repository.PhotoRepository
import wep.app.emilioenlaluna.projectnavphoto.viewmodel.PhotoViewModel

class PhotoListFragment : Fragment(R.layout.fragment_photo_list) {
    private lateinit var viewModel: PhotoViewModel
    private lateinit var photoAdapter: PhotoAdapter
    private var _binding: FragmentPhotoListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPhotoListBinding.bind(view)

        // Obtener el ViewModel
        val photoDao = AppDatabase.getDatabase(requireContext()).photoDao()
        val repository = PhotoRepository(photoDao)
        val factory = PhotoViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(PhotoViewModel::class.java)

        // Configurar RecyclerView
        photoAdapter = PhotoAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = photoAdapter

        // Observar los datos
        viewModel.photos.observe(viewLifecycleOwner, { photos ->
            photoAdapter.submitList(photos)
        })

        // Obtener las fotos
        viewModel.fetchPhotos()

        // Configurar el botón de agregar
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_photoListFragment_to_cameraFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
