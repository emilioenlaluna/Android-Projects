
package wep.app.emilioenlaluna.examenconvertidor.fragments

import androidx.lifecycle.ViewModel
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import kotlin.properties.Delegates

class CelsiusViewModel : ViewModel(), Observable {

    private val callbacks = PropertyChangeRegistry()

    @get:Bindable
    var celsius: String by Delegates.observable("") { _, _, _ ->
        notifyChange()
    }

    @get:Bindable
    val fahrenheit: Double
        get() = (celsius.toDoubleOrNull() ?: 0.0) * 9 / 5 + 32

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