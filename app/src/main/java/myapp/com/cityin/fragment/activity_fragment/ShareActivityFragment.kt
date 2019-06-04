package myapp.com.cityin.fragment.activity_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.share_activity_modal.*
import kotlinx.android.synthetic.main.share_activity_modal.view.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.TravelBandHorizontalAdpater
import myapp.com.cityin.fragment.wish_list_fragment.CreateWishlistDialog
import myapp.com.cityin.network.ActivitiesService
import myapp.com.cityin.network.FoldersService
import myapp.com.cityin.network.response.Folder

class ShareActivityFragment(activityId: String): BottomSheetDialogFragment(), CreateWishlistDialog.NoticeDialogListener, TravelBandHorizontalAdpater.TravelBandItemListener {

    val activityId = activityId

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.share_activity_modal, container, false)

        view.share_activity_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        loadTravelBands()

        view.share_activity_create_wishlist.setOnClickListener {
            Log.d("test", "wants to create a travel band")
            val createTravelBandDialog = CreateWishlistDialog()
            createTravelBandDialog.setTargetFragment(this, 0)
            createTravelBandDialog.show(fragmentManager, "CreateTravelBandDialog")
        }

        return view
    }

    override fun onDialogDismissSuccessfully(dialog: DialogFragment) {
        loadTravelBands()
    }

    /**
     * Event handler when user clicks on a travel band item -> Share an activity to given travel band
     */
    override fun onItemClick(travelBand: Folder) {
        ActivitiesService.shareActivityToTravelBand(activityId, travelBand.travelBandId, {
            dismiss()
        }, {
            Log.d("test", it.toString())
        })
    }

    private fun loadTravelBands() {
        FoldersService.getFolders({
            travelBands -> travelBands.size
            val adapter = TravelBandHorizontalAdpater(travelBands)
            adapter.listener = this
            share_activity_recycler_view.adapter = adapter

        }, {
            Log.d("test", "error")
        })
    }
}