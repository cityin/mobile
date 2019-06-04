package myapp.com.cityin.fragment.wish_list_fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import myapp.com.cityin.R
import kotlinx.android.synthetic.main.fragment_add_spotters_activities.*
import myapp.com.cityin.adapter.SpotterAdapter
import myapp.com.cityin.network.SpotterService


class ConfirmAddSpottersActivitiesFragment : DialogFragment() {

    lateinit var travelBandId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_spotters_activities, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        spotterRecyclerView.layoutManager = LinearLayoutManager(context)

        SpotterService.getSpotters(travelBandId, {
            spotters -> spotters.size
            spotterRecyclerView.adapter = SpotterAdapter(spotters)
        }, {

        })

        val action = AddSpottersActivitiesFragmentDirections.actionAddSpottersActivitiesFragmentToInviteSpottersFragment(travelBandId)

        addSpotter.setOnClickListener {
            this.findNavController().navigate(action)
        }

        btnCloseAddSpotterFragment.setOnClickListener {
            this.findNavController().popBackStack()
        }
    }


}
