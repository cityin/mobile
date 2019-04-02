package myapp.com.cityin.fragment.wish_list_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_incoming.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderActivitiesAdapter
import myapp.com.cityin.network.ActivitiesService

class WishListFragmentTravelBandActivities : Fragment() {
    val args: WishListFragmentTravelBandActivitiesArgs by navArgs()
    lateinit var folderId: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wish_list_fragment_folder_activities, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        folderId = args.folderId

        activitiesRecyclerView.layoutManager = LinearLayoutManager(context)

        ActivitiesService.getActivitiesByTravelBandId(folderId, {
            activities -> activities.size
            activitiesRecyclerView.adapter = FolderActivitiesAdapter(activities)
        }, {

        })


    }
}