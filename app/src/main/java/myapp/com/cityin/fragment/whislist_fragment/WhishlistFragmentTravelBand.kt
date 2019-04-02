package myapp.com.cityin.fragment.whislist_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_whish_list_fragment_travel_band.*

import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderAdapter
import myapp.com.cityin.network.FoldersService

class WhishlistFragmentTravelBand : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whish_list_fragment_travel_band, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        foldersRecyclerView.layoutManager = LinearLayoutManager(context)

        FoldersService.getFolders({
            folders -> folders.size
            foldersRecyclerView.adapter = FolderAdapter(folders)
        }, {

        })
    }
}
