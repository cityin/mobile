package myapp.com.cityin.adapter


import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*
import kotlinx.android.synthetic.main.item_activity_votable.view.*
import myapp.com.cityin.CityInApp
import myapp.com.cityin.R
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandActivitiesDirections
import myapp.com.cityin.network.VotesService
import myapp.com.cityin.network.response.Activity
import myapp.com.cityin.network.response.Spotters

class FolderActivitiesAdapter(val activities: Array<Activity>) : RecyclerView.Adapter<CustomFolderActivitiesViewHolder>() {
    val categoryIconsTwo = hashMapOf("loisir" to R.drawable.ic_local_bar_white_20dp,
            "sport" to R.drawable.ic_pool_white_20dp,
            "culture" to R.drawable.ic_culture_white_20dp,
            "exploration" to R.drawable.ic_map_white_20dp)

    private lateinit var context: Context

    private fun setSpotterVoteAction(reactions: MutableList<Spotters>, spotters: Spotters): MutableList<Spotters> {
        val currentSpotter = reactions.find {
            it.spotterId == CityInApp.spotterId
        }

        val spotterIndex = reactions.indexOf(currentSpotter)
        val newReactionsArray: MutableList<Spotters> = reactions

        if (currentSpotter !== null && spotterIndex >= 0) {
            newReactionsArray.set(spotterIndex, spotters)
        } else {
            newReactionsArray.add(spotters)
        }

        return newReactionsArray
    }

    private fun setVoteState(activity: Activity, holder: CustomFolderActivitiesViewHolder) {
        val arrayOfSpotters = activity.reactions

        val userReaction = arrayOfSpotters.find {
            it.spotterId == CityInApp.spotterId
        }

        if (userReaction !== null) {
            if (userReaction.like) {
                postInterestedVote(holder)
            } else {
                postNonInterestedVote(holder)
            }
        }
    }

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

        context = parent.context

        return CustomFolderActivitiesViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
        return activities.count()
    }

    override fun onBindViewHolder(holder: CustomFolderActivitiesViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.view.activityVotableNameTextView.text = activity.name
        holder.view.priceVotableActivityTextView.text = "${activity.price}€/pers"
        holder.view.category_votable_name_activity.text = activity.category?.name.capitalize()

        val categoryIcon = categoryIconsTwo[activity.category.name] ?: 0
        if (categoryIcon != 0) {
            holder.view.category_votable_icon_activity.setImageResource(categoryIcon)
        }

        val cardPicture = holder.view.activityVotableImageView

        Picasso.get().load(activity.pictures[0]).into(cardPicture)

        if (activity.reactions.isNotEmpty()) {
            setVoteState(activity, holder)

            holder.view.item_activity_votable_spotter_recycler_view.visibility = View.VISIBLE

            holder.view.item_activity_votable_spotter_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            holder.view.item_activity_votable_spotter_recycler_view.adapter = SpotterVotesAdapter(activity.reactions)
        } else {
            holder.view.item_activity_votable_spotter_recycler_view.visibility = View.GONE
        }

        val activityId: String
        activityId = activity.activityId
        val travelBandId: String
        travelBandId = activity.travelBandId

        val action = WishListFragmentTravelBandActivitiesDirections.actionWishListFragmentTravelBandActivitiesToDetailsActivitiesFragment(activityId, travelBandId)

        holder.view.activityVotableImageView.setOnClickListener {
            it.findNavController().navigate(action)
        }

        holder.view.item_activity_check_button.setOnClickListener {
            postInterestedVote(holder)

            VotesService.postInterestVote(travelBandId, activityId, {
                val newReactions = setSpotterVoteAction(activity.reactions, it)

                holder.view.item_activity_votable_spotter_recycler_view.visibility = View.VISIBLE

                holder.view.item_activity_votable_spotter_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                
                holder.view.item_activity_votable_spotter_recycler_view.adapter = SpotterVotesAdapter(newReactions)
            }, {

            })
        }

        holder.view.item_activity_clear_button.setOnClickListener {
            postNonInterestedVote(holder)

            VotesService.postNonInterestVote(travelBandId, activityId, {
                val newReactions = setSpotterVoteAction(activity.reactions, it)

                holder.view.item_activity_votable_spotter_recycler_view.visibility = View.VISIBLE

                holder.view.item_activity_votable_spotter_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                holder.view.item_activity_votable_spotter_recycler_view.adapter = SpotterVotesAdapter(newReactions)
            }, {

            })
        }
    }
}


class CustomFolderActivitiesViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}

