package com.example.lab35

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lab35.databinding.FragmentThirdBinding
import kotlin.random.Random

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayWeeklyTemperatures()

        binding.button1.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }
    }


    private fun displayWeeklyTemperatures() {
        val temperatures: List<Int> = List(7) { Random.nextInt(5, 25) }
        val daysOfWeek = listOf(
            getString(R.string.monday),
            getString(R.string.tuesday),
            getString(R.string.wednesday),
            getString(R.string.thursday),
            getString(R.string.friday),
            getString(R.string.saturday),
            getString(R.string.sunday)
        )
        binding.textView5.text  = daysOfWeek.zip(temperatures) { day, temp ->
            "$day - $temp°C"
        }.joinToString("\n")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}