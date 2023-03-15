package com.example.Fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentPhotoGrapherBinding

class PhotoGrapherFragment : Fragment() {

    lateinit var binding: FragmentPhotoGrapherBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotoGrapherBinding.inflate(layoutInflater , container , false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}