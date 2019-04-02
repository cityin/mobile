package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_folder.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.wish_list_fragment.WishListFragmentTravelBandDirections
import myapp.com.cityin.network.response.Folder

class FolderAdapter(val folders: Array<Folder>): RecyclerView.Adapter<CustomViewHolder>() {

    // Return numbers of items
    override fun getItemCount(): Int {
        return folders.count()
    }

    // How to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_folder, parent, false)

        return CustomViewHolder(cellFlow)
    }

    // How to bind the data into the view
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val folder = folders.get(position)

        holder.itemView.folderTitleTextView.text = folder.name
        holder.view.folderNumberOfActivitiesTextView.text = "| ${folder.activityCount} activités"

        // Use Picasso to set the image url into the cardView
        val cardPicture = holder.itemView.folderImageView

        Picasso.get().load(folder.thumbnailUrl).into(cardPicture)


        val folderId: String

        folderId = folder.travelBandId

        val action = WishListFragmentTravelBandDirections.actionFromTravelBandToActivities(folderId)

        holder.view.setOnClickListener{
            it.findNavController().navigate(action)
        }

    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {}