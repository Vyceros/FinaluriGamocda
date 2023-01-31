package com.example.finaluriterm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluriterm.Filmebi
import com.example.finaluriterm.MovieInfo
import com.example.finaluriterm.Movies
import com.example.finaluriterm.R
import kotlinx.coroutines.NonDisposableHandle.parent

class MovieAdapt(private val movieslist:ArrayList<Filmebi>)
    : RecyclerView.Adapter<MovieAdapt.MovieHolder>() {

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.foto)
        val movieName: TextView = itemView.findViewById(R.id.name)
        val descriPtion: TextView = itemView.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movieslist[position]
        holder.imageView.setImageResource(movie.image)
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
    }

    override fun getItemCount(): Int {
        return movieslist.size

    }
}
