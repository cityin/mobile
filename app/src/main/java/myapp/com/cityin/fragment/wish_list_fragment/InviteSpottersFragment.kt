package myapp.com.cityin.fragment.wish_list_fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_spotters_activities.*
import kotlinx.android.synthetic.main.fragment_details_activities.view.*
import myapp.com.cityin.R
import kotlinx.android.synthetic.main.fragment_invite_spotter.*
import kotlinx.android.synthetic.main.fragment_invite_spotter.view.*
import myapp.com.cityin.adapter.SpotterAdapter
import myapp.com.cityin.adapter.SpotterAddAdapter
import myapp.com.cityin.network.SpotterService
import myapp.com.cityin.network.response.Spotters


class InviteSpottersFragment : androidx.fragment.app.Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_invite_spotter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name = "test"

        SpotterService.getAddSpotters(name, {
            spotters -> spotters.size

        }, {

        })

        btnCloseInviteFragment.setOnClickListener {
            this.findNavController().popBackStack()
        }

    }
}
