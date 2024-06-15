package wep.app.emilioenlaluna.projectnavphoto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import wep.app.emilioenlaluna.projectnavphoto.entity.Photo
import wep.app.emilioenlaluna.projectnavphoto.repository.PhotoRepository

class PhotoViewModel(private val repository: PhotoRepository) : ViewModel() {
    val photos = MutableLiveData<List<Photo>>()

    fun insert(photo: Photo) = viewModelScope.launch {
        repository.insert(photo)
    }

    fun fetchPhotos() = viewModelScope.launch {
        photos.postValue(repository.getAllPhotos())
    }
}