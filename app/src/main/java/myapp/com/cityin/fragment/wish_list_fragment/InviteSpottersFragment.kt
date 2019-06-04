package myapp.com.cityin.fragment.wish_list_fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import myapp.com.cityin.R
import kotlinx.android.synthetic.main.fragment_invite_spotter.*
import myapp.com.cityin.CityInApp
import myapp.com.cityin.adapter.SpotterAdapter
import myapp.com.cityin.network.SpotterService
import myapp.com.cityin.network.response.Spotters
import java.util.*
import kotlin.concurrent.schedule


class InviteSpottersFragment : androidx.fragment.app.Fragment(), SpotterAdapter.SpotterClickedListener {

    val args: InviteSpottersFragmentArgs by navArgs()
    lateinit var travelBandId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_invite_spotter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        travelBandId = args.travelBandId

        btnCloseInviteFragment.setOnClickListener {
            this.findNavController().popBackStack()
        }

        search_spotter_name.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (search_spotter_name.text.isEmpty()) {

//                    displayViews()

                } else {
                    searchSpotters(s)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    private fun searchSpotters(s: Editable?) {
        CityInApp.requestQueue.cancelAll(this)

        found_spotters_recycler_view.layoutManager = LinearLayoutManager(context)

        SpotterService.getAddSpotters(s?.toString() ?: "",{
            spotters -> spotters.size
            val adapter = SpotterAdapter(spotters)
            adapter.listener = this
            found_spotters_recycler_view.adapter = adapter
        }, {
            Log.d("test", it.toString())
        })
    }

    override fun Clicked(spotter: Spotters) {
        SpotterService.inviteSpotter(travelBandId, spotter.spotterId, {
            findNavController().popBackStack()
        }, {
            Log.d("test", it.toString())
        })
    }
}
