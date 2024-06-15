package wep.app.emilioenlaluna.examenconvertidor.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import wep.app.emilioenlaluna.examenconvertidor.R
import wep.app.emilioenlaluna.examenconvertidor.databinding.FragmentFahrenheitBinding

class FahrenheitFragment : Fragment() {

    private lateinit var binding: FragmentFahrenheitBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fahrenheit, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(FahrenheitViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        navController = Navigation.findNavController(view)

        binding.navigateToCelsiusButton.setOnClickListener {
            navController.navigate(R.id.action_fahrenheitFragment_to_celsiusFragment)
        }
    }
}
