package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.wish_list_fragment.CreateWishlistDialog
import myapp.com.cityin.network.response.Folder

class TravelBandHorizontalAdpater(val travelBands: Array<Folder>): RecyclerView.Adapter<TravelBandHorizontalAdpater.ViewHolder>(){

    lateinit var listener: TravelBandItemListener

    interface TravelBandItemListener {
        fun onItemClick(travelBand: Folder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_travelband_horizontal, parent, false)

        return ViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
        return travelBands.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val travelBand = travelBands.get(position)
        val picture = holder.view.travel_band_image_view

        holder.view.travel_band_title.text = travelBand.name

        Picasso.get().load(travelBand.thumbnailUrl).into(picture)

        holder.view.setOnClickListener {
            listener.onItemClick(travelBand)
        }
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {}


}