package com.example.finaluriterm

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_info, container, false)
        val imgView = view.findViewById<ImageView>(R.id.imageView)
        val nameMovie = view.findViewById<TextView>(R.id.saxeli)
        val descMovie = view.findViewById<TextView>(R.id.agwera)
        val bundle = this.arguments
        if (bundle != null) {
            val myInt = bundle.getInt("img", 0)
            val myString = bundle.getString("title", "")
            val myDesc = bundle.getString("desc", "")
            nameMovie.text = myString
            descMovie.text= myDesc
            descMovie.movementMethod = ScrollingMovementMethod()
            imgView.setImageResource(myInt)
        }

        return view
    }
}