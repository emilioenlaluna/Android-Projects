package wep.app.emilioenlaluna.projectnavphoto.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Esto permite que Room genere automáticamente el ID
    val uri: String
)
