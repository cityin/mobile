package myapp.com.cityin.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*
import kotlinx.android.synthetic.main.item_activity_votable.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandActivitiesDirections
import myapp.com.cityin.network.response.Activity

class FolderActivitiesAdapter(val activities: Array<Activity>): RecyclerView.Adapter<CustomFolderActivitiesViewHolder>() {

    private fun postInterestedVote(holder: CustomFolderActivitiesViewHolder) {
        holder.view.item_activity_check_icon.setImageResource(R.drawable.ic_check_green_24dp)
        holder.view.item_activity_clear_icon.setImageResource(R.drawable.ic_clear_grey_24dp)
        //
        holder.view.item_activity_votable_interested_text.setTextColor(Color.parseColor("#42b72a"))
        holder.view.item_activity_votable_non_interested_text.setTextColor(Color.parseColor("#757575"))
    }

    private fun postNonInterestedVote(holder: CustomFolderActivitiesViewHolder) {
        holder.view.item_activity_check_icon.setImageResource(R.drawable.ic_check_grey_24dp)
        holder.view.item_activity_clear_icon.setImageResource(R.drawable.ic_clear_red_24dp)
        //
        holder.view.item_activity_votable_interested_text.setTextColor(Color.parseColor("#757575"))
        holder.view.item_activity_votable_non_interested_text.setTextColor(Color.parseColor("#f53535"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomFolderActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_activity_votable, parent, false)

        return CustomFolderActivitiesViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
       return activities.count()
    }

    override fun onBindViewHolder(holder: CustomFolderActivitiesViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.view.activityVotableNameTextView.text = activity.name
        holder.view.priceVotableActivityTextView.text = "${activity.price}€/pers"

        holder.view.category_votable_icon_name.visibility = View.INVISIBLE

        val cardPicture = holder.view.activityVotableImageView

        Picasso.get().load(activity.pictures[0]).into(cardPicture)

        val activityId: String
        activityId = activity.activityId
        val travelBandId: String
        travelBandId = activity.travelBandId

        val action = WishListFragmentTravelBandActivitiesDirections.actionWishListFragmentTravelBandActivitiesToDetailsActivitiesFragment(activityId,travelBandId)

        holder.view.activityVotableImageView.setOnClickListener {
            it.findNavController().navigate(action)
        }

        holder.view.item_activity_check_button.setOnClickListener {
            postInterestedVote(holder)
        }

        holder.view.item_activity_clear_button.setOnClickListener {
            postNonInterestedVote(holder)
        }
    }
}

class CustomFolderActivitiesViewHolder(val view: View): RecyclerView.ViewHolder(view) {}