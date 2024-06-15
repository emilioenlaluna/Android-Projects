package wep.app.emilioenlaluna.projectnavphoto.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import wep.app.emilioenlaluna.projectnavphoto.entity.Photo

@Dao
interface PhotoDao {
    @Insert
    suspend fun insert(photo: Photo)

    @RawQuery
    suspend fun getAllPhotos(query: SupportSQLiteQuery): List<Photo>
}
