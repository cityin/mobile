package myapp.com.cityin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_incoming.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.SuggestionAdapter
import myapp.com.cityin.network.ActivitiesService


class IncomingFragment : androidx.fragment.app.Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_incoming, container, false)

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