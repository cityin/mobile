package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_spotters.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.response.Spotters

class SpotterItemsAdapter(val spotters: Array<Spotters>): RecyclerView.Adapter<CustomSpotterItemsViewHolder>() {

    // Return numbers of items
    override fun getItemCount(): Int {
        return spotters.count()
    }

    // How to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomSpotterItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_spotter_img, parent, false)

        return CustomSpotterItemsViewHolder(cellFlow)
    }

    // How to bind the data into the view
    override fun onBindViewHolder(holder: CustomSpotterItemsViewHolder, position: Int) {
        val spotter = spotters.get(position)
        val cardPicture = holder.view.imageSpotter

        Picasso.get().load(spotter.thumbnailUrl).into(cardPicture)
    }
}

class CustomSpotterItemsViewHolder(val view: View): RecyclerView.ViewHolder(view) {}