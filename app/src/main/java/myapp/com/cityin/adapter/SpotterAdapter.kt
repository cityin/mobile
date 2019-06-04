package myapp.com.cityin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_folder.view.*
import kotlinx.android.synthetic.main.item_spotters.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.WishlistFragment
import myapp.com.cityin.fragment.WishlistFragmentDirections
import myapp.com.cityin.network.response.Folder
import myapp.com.cityin.network.response.Spotters

class SpotterAdapter(val spotters: Array<Spotters>): RecyclerView.Adapter<CustomSpotterViewHolder>() {

    // Return numbers of items
    override fun getItemCount(): Int {
        return spotters.count()
    }

    // How to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomSpotterViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_spotters, parent, false)

        return CustomSpotterViewHolder(cellFlow)
    }

    // How to bind the data into the view
    override fun onBindViewHolder(holder: CustomSpotterViewHolder, position: Int) {
        val spotter = spotters.get(position)
        val cardPicture = holder.view.imageSpotter

        Picasso.get().load(spotter.thumbnailUrl).into(cardPicture)
        holder.view.nameSpotter.text = spotter.username.toString()
    }
}

class CustomSpotterViewHolder(val view: View): RecyclerView.ViewHolder(view) {}