package myapp.com.cityin.fragment.wish_list_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_wish_list_fragment_folder_activities.*
import kotlinx.android.synthetic.main.item_activity.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderActivitiesAdapter
import myapp.com.cityin.adapter.SpotterItemsAdapter
import myapp.com.cityin.adapter.SpotterVotesAdapter
import myapp.com.cityin.network.ActivitiesService
import myapp.com.cityin.network.response.Spotters



class WishListFragmentTravelBandActivities : androidx.fragment.app.Fragment() {
    val args: WishListFragmentTravelBandActivitiesArgs by navArgs()
    lateinit var folderId: String
    lateinit var folderName: String
    lateinit var folderDesription: String
    lateinit var folderSpotter: Array<Spotters>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wish_list_fragment_folder_activities, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        backBtn.setOnClickListener {
            this.findNavController().popBackStack()
        }

        folderId = args.folderId
        folderName = args.folderName
        val folderActivity = args.folderActivity.toInt()
        folderDesription = args.folderDescription
        folderSpotter = args.folderSpotter

        TitleTravelBand.text = folderName.toString()
        descriptionTravelBand.text = folderDesription.toString()
        folderNumberOfActivitiesTextView.text = "${folderActivity.toString()} activités enregistrées"

        var recyclerView = ItemsSpotterRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = SpotterItemsAdapter(folderSpotter)

        activitiesRecyclerView.layoutManager = LinearLayoutManager(context)

        val action = WishListFragmentTravelBandActivitiesDirections.actionWishListFragmentTravelBandActivitiesToAddSpottersActivitiesFragment(folderId)

        settingsBtn.setOnClickListener {
            this.findNavController().navigate(action)
        }

        containerItemsSpotter.setOnClickListener {
            this.findNavController().navigate(action)
        }

        ActivitiesService.getActivitiesByTravelBandId(folderId, {
            activities -> activities.size
            activitiesRecyclerView?.adapter = FolderActivitiesAdapter(activities)

            ViewCompat.setNestedScrollingEnabled(activitiesRecyclerView, false);
        }, {})


    }
}