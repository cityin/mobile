package myapp.com.cityin.fragment.fragmentPeoplePage


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import myapp.com.cityin.R

class SuggestionFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}
