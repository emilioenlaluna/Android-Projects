package wep.app.emilioenlaluna.projectnavphoto.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import wep.app.emilioenlaluna.projectnavphoto.repository.PhotoRepository
import wep.app.emilioenlaluna.projectnavphoto.viewmodel.PhotoViewModel

class PhotoViewModelFactory(private val repository: PhotoRepository) : ViewModelProvider.Factory {
    fun <T : ViewModel> createViewModel(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            return PhotoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}