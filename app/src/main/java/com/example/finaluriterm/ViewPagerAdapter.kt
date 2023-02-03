package com.example.finaluriterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> Profile()
            1 -> ChangePassword()
            else ->  Profile()
        }
    }

    fun getPageTitle(position: Int): String {
        return when (position) {
            0 -> "Favorites"
            1 -> "Profile"
            else -> "Profile"
        }
    }
}