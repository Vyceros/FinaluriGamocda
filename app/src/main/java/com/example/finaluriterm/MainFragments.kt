package com.example.finaluriterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainFragments:Fragment(R.layout.main_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.navgiation)


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.movies -> {
                    // Replace the current fragment with Fragment1
                    val fragment1 =Movies()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.mainContainer1, fragment1)
                    transaction?.commit()
                    true
                }

                R.id.profile-> {
                    // Replace the current fragment with Fragment1
                    val fragment1 = OtherFragment()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.mainContainer1, fragment1)
                    transaction?.commit()
                    true
                }
                else -> false
            }
        }
        return view
    }
}
