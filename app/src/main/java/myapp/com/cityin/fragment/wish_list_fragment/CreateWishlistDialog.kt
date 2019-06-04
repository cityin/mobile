package myapp.com.cityin.fragment.wish_list_fragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.create_wishlist_dialog.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.FoldersService

class CreateWishlistDialog: DialogFragment() {

    var travelBandCreated = false

    // Use this instance of the interface to deliver action events
    internal lateinit var listener: NoticeDialogListener

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    interface NoticeDialogListener {
        fun onDialogDismissSuccessfully(dialog: DialogFragment)
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = targetFragment as NoticeDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout to use as dialog or embedded fragment
        val view = inflater.inflate(R.layout.create_wishlist_dialog, container, false)

        view.create_wishlist_action.setOnClickListener {
            val name = view.edit_wishlist_name.text.toString()
            val description = view.edit_wishlist_description.text.toString()

            if (validateFields(name, description)) {
                FoldersService.createTravelBand(name, description, {
                    Log.d("test", "successfully created travel band")
                    travelBandCreated = true
                    dismiss()
                }, {
                    Log.d("test", it.toString())
                    // TODO: SHOW ERROR
                })
            } else {
                // Display error
                view.create_wishlist_error.text = getString(R.string.create_wishlist_invalid)
                view.create_wishlist_error.visibility = View.VISIBLE
            }
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (!travelBandCreated) {
            return
        }
        listener.onDialogDismissSuccessfully(this)
    }

    private fun validateFields(name: String, description: String): Boolean {
        return name.length > 3
    }
}
