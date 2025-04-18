package com.example.modcapp.ui.home

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.modcapp.R
import com.example.modcapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.txtTodayDate
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        setMenu(binding.txtSound, "အသံ (Audio)", R.id.action_navigation_home_to_sound)
        setMenu(binding.txtVideo, "ဗီဒီယို (Video)", R.id.action_navigation_home_to_video)
        setMenu(binding.txtBook, "တရားစာအုပ် (Dhamma Books)", R.id.action_navigation_home_to_book)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setMenu(linkText: TextView, source: String, resId: Int) {
        val spannableString = SpannableString(source)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                findNavController().navigate(resId)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = ContextCompat.getColor(requireContext(), R.color.purple_500)
            }
        }

        spannableString.setSpan(
            clickableSpan,
            0,
            spannableString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        linkText.text = spannableString
        linkText.movementMethod = LinkMovementMethod.getInstance()
    }

}