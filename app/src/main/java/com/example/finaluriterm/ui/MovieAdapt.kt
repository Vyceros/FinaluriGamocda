package com.example.finaluriterm.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluriterm.*
import kotlinx.coroutines.NonDisposableHandle.parent

class MovieAdapt(private val context: Context, private val movieslist:ArrayList<Filmebi>)
    : RecyclerView.Adapter<MovieAdapt.MovieHolder>() {

    private val savedItems = FavoritesHelper(context)
    private val mItemList = savedItems.getSavedItems()

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.foto)
        val movieName: TextView = itemView.findViewById(R.id.name)
        val descriPtion: TextView = itemView.findViewById(R.id.description)
        val favButton : ImageButton = itemView.findViewById(R.id.fav_ib)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movieslist[position]
        val savedItems = FavoritesHelper(context)
        val mItemList = savedItems.getSavedItems()
        val b = mItemList.contains(movie)
        holder.imageView.setImageResource(movie.image)
        if (b){
            holder.favButton.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.baseline_favorite_24))
        }
        holder.movieName.text = movie.name
        holder.descriPtion.text = movie.description

        holder.itemView.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("title", movie.name)
            bundle.putInt("img", movie.image)
            bundle.putString("desc", movie.description)


            val fragment = MovieInfo()
            fragment.arguments = bundle

            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, fragment, null)
                .addToBackStack(null)
                .commit()

        }

        holder.favButton.setOnClickListener {
            if (b){
                holder.favButton.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.baseline_favorite_border_24))
                removeFromFavorites(movie)
            }
            else{
                holder.favButton.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.baseline_favorite_24))
                addToFavorites(movie)
            }
        }

    }

    private fun removeFromFavorites(movie: Filmebi) {
        mItemList.remove(movie)
        savedItems.saveItems(mItemList)
        Toast.makeText(context,"Movie removed from favorites",Toast.LENGTH_SHORT).show()
    }

    private fun addToFavorites(movie: Filmebi) {
        mItemList.add(movie)
        savedItems.saveItems(mItemList)
        Toast.makeText(context,"Movie added to favorites",Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return movieslist.size

    }
}
