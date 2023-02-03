package com.example.finaluriterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class profileViewPager: Fragment(R.layout.profile_viewpager) {
    private lateinit var textView : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_viewpager, container, false)
        textView = view.findViewById(R.id.profileText)
        textView.text = "Hello ${FirebaseAuth.getInstance().currentUser?.email.toString().substring(0,FirebaseAuth.getInstance().currentUser?.email.toString().indexOf('@'))}"

        return view
    }
}