package com.example.modcapp.ui.sound

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.modcapp.databinding.FragmentSoundBinding

class SoundFragment : Fragment() {

    private var _binding: FragmentSoundBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val soundViewModel =
            ViewModelProvider(this).get(SoundViewModel::class.java)

        _binding = FragmentSoundBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSound
        soundViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}