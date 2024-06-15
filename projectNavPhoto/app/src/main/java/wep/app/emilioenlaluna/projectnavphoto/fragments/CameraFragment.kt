package wep.app.emilioenlaluna.projectnavphoto.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import wep.app.emilioenlaluna.projectnavphoto.R
import wep.app.emilioenlaluna.projectnavphoto.databinding.FragmentCameraBinding
import wep.app.emilioenlaluna.projectnavphoto.db.AppDatabase
import wep.app.emilioenlaluna.projectnavphoto.entity.Photo
import wep.app.emilioenlaluna.projectnavphoto.factory.PhotoViewModelFactory
import wep.app.emilioenlaluna.projectnavphoto.repository.PhotoRepository
import wep.app.emilioenlaluna.projectnavphoto.viewmodel.PhotoViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale

class CameraFragment : Fragment(R.layout.fragment_camera) {
    private lateinit var viewModel: PhotoViewModel
    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageCapture: ImageCapture

    private val outputDirectory: File by lazy {
        requireContext().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        } ?: requireContext().filesDir
    }

    private val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCameraBinding.bind(view)

        // Obtener el ViewModel
        val photoDao = AppDatabase.getDatabase(requireContext()).photoDao()
        val repository = PhotoRepository(photoDao)
        val factory = PhotoViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(PhotoViewModel::class.java)

        // Configurar CameraX
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
            }
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            imageCapture = ImageCapture.Builder().build()

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)
            } catch (exc: Exception) {
                Log.e("CameraFragment", "Use case binding failed", exc)
            }

            // Configurar el botón de captura
            binding.captureButton.setOnClickListener {
                takePhoto()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun takePhoto() {
        val photoFile = File(
            outputDirectory,
            SimpleDateFormat(FILENAME_FORMAT, Locale.US)
                .format(System.currentTimeMillis()) + ".jpg"
        )

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        imageCapture.takePicture(
            outputOptions, ContextCompat.getMainExecutor(requireContext()), object : ImageCapture.OnImageSavedCallback {
                override fun onError(exception: ImageCaptureException) {
                    Log.e("CameraFragment", "Photo capture failed: ${exception.message}", exception)
                }

                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    viewModel.insert(Photo(uri = savedUri.toString()))
                    findNavController().navigate(R.id.action_cameraFragment_to_photoListFragment)
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
