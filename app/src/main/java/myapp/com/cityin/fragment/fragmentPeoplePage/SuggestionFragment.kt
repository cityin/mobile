package myapp.com.cityin.fragment.fragmentPeoplePage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sugg.*

import myapp.com.cityin.R

class SuggestionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        suggestion_fragment.text = "fragment one"
    }


}