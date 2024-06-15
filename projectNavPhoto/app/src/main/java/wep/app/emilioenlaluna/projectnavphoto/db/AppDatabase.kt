package wep.app.emilioenlaluna.projectnavphoto.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import wep.app.emilioenlaluna.projectnavphoto.dao.PhotoDao
import wep.app.emilioenlaluna.projectnavphoto.entity.Photo

@Database(entities = [Photo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "photo_database"
                )
                    .fallbackToDestructiveMigration() // Permite migraciones destructivas
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
