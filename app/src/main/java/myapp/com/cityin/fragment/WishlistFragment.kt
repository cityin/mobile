package myapp.com.cityin.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.create_wishlist_dialog.*
import kotlinx.android.synthetic.main.fragment_wishlist.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderAdapter
import myapp.com.cityin.fragment.wish_list_fragment.CreateWishlistDialog
import myapp.com.cityin.network.FoldersService
import android.R.id
import android.content.DialogInterface
import androidx.fragment.app.DialogFragment


class WishlistFragment : androidx.fragment.app.Fragment(), CreateWishlistDialog.NoticeDialogListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        foldersRecyclerView.layoutManager = LinearLayoutManager(context)
        loadTravelBands()

        // set up click on add
        add_wishlist_icon.setOnClickListener {
            val dialog = CreateWishlistDialog()
            dialog.setTargetFragment(this, 0)
            dialog.show(fragmentManager, "CreateWishlistDialog")
        }
    }

    private fun loadTravelBands() {
        FoldersService.getFolders({
            folders -> folders.size
            Log.d("test", "${folders.size}")
            foldersRecyclerView.adapter = FolderAdapter(folders)

            ViewCompat.setNestedScrollingEnabled(foldersRecyclerView, false)
        }, {

        })
    }

    override fun onDialogDismissSuccessfully(dialog: DialogFragment) {
        // Reload travel bands to fetch newly created one
        loadTravelBands()
    }

}