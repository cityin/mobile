package myapp.com.cityin.fragment.fragmentPeoplePage


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sugg.*

import myapp.com.cityin.R
import myapp.com.cityin.adapter.SuggestionAdapter
import myapp.com.cityin.network.ActivitiesService

class SuggestionFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugg, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activitiesRecyclerView.layoutManager = LinearLayoutManager(context)

        ActivitiesService.getActivities({
            activities -> activities.size
            activitiesRecyclerView.adapter = SuggestionAdapter(activities)
        }, {
        })
    }

}
