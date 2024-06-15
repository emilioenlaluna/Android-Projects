package wep.app.emilioenlaluna.projectnavphoto

import android.app.Application
import wep.app.emilioenlaluna.projectnavphoto.db.AppDatabase

// MyApplication.kt
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getDatabase(this)
    }
}