package com.example.finaluriterm

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MovieInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_info, container, false)
        val imgView = view.findViewById<ImageView>(R.id.imageView)
        val nameMovie = view.findViewById<TextView>(R.id.saxeli)
        val crocoNet : TextView = view.findViewById(R.id.croco)
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
        crocoNet.movementMethod = LinkMovementMethod.getInstance()
        crocoNet.setLinkTextColor(Color.BLUE)
        return view
    }
}