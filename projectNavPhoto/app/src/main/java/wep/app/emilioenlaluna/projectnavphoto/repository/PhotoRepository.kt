package wep.app.emilioenlaluna.projectnavphoto.repository

import wep.app.emilioenlaluna.projectnavphoto.dao.PhotoDao
import wep.app.emilioenlaluna.projectnavphoto.entity.Photo

class PhotoRepository(private val photoDao: PhotoDao) {
    suspend fun insert(photo: Photo) = photoDao.insert(photo)
    suspend fun getAllPhotos() = photoDao.getAllPhotos()
}