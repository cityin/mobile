package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.WishlistFragment
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandActivities
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandActivitiesDirections
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandDirections
import myapp.com.cityin.network.response.Activity
import myapp.com.cityin.network.response.Folder

class FolderActivitiesAdapter(val activities: Array<Activity>): RecyclerView.Adapter<CustomFolderActivitiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomFolderActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_activity, parent, false)

        return CustomFolderActivitiesViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
       return activities.count()
    }

    override fun onBindViewHolder(holder: CustomFolderActivitiesViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.view.activityNameTextView.text = activity.name
        holder.view.activityMarkRateTextView.text = activity.mark.toString()
        holder.view.activityRatingBar.rating = activity.mark.toFloat()
        holder.view.activityPriceTextView.text = "${activity.price.toString()}€ par personnes"
        holder.view.activityVotesTextView.text = activity.nbVotes.toString()

        val cardPicture = holder.view.activityImageView

        Picasso.get().load(activity.pictures[0]).into(cardPicture)

        val activityId: String
        activityId = activity.activityId
        val travelBandId: String
        travelBandId = activity.travelBandId

        val action = WishListFragmentTravelBandActivitiesDirections.actionWishListFragmentTravelBandActivities2ToDetailsActivitiesFragment3(activityId,travelBandId)

        holder.view.activityCardView.setOnClickListener{
            it.findNavController().navigate(action)
        }

    }
}

class CustomFolderActivitiesViewHolder(val view: View): RecyclerView.ViewHolder(view) {}