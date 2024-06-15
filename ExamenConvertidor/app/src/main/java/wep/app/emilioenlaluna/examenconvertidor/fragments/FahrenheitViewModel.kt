package wep.app.emilioenlaluna.examenconvertidor.fragments

import androidx.lifecycle.ViewModel
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import kotlin.properties.Delegates

class FahrenheitViewModel : ViewModel(), Observable {

    private val callbacks = PropertyChangeRegistry()

    @get:Bindable
    var fahrenheit: String by Delegates.observable("") { _, _, _ ->
        notifyChange()
    }

    @get:Bindable
    val celsius: Double
        get() = (fahrenheit.toDoubleOrNull() ?: 0.0 - 32) * 5 / 9

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    private fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }
}