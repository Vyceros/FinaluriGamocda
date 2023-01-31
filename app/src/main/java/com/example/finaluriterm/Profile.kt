package com.example.finaluriterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluriterm.ui.FavoritesAdapter
import com.example.finaluriterm.ui.MovieAdapt

class Profile : Fragment(R.layout.fragment_profile) {
    private lateinit var mData: FavoritesHelper
    private lateinit var savedItems: ArrayList<Filmebi>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mData = FavoritesHelper(requireContext())
        savedItems = mData.getSavedItems()

        recyclerView = view.findViewById(R.id.recyclerview)

        val adapter = FavoritesAdapter(requireContext(),savedItems)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }
}