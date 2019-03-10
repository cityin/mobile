package myapp.com.cityin.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import kotlinx.android.synthetic.main.fragment_people.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.fragmentPeoplePage.ActivitiesFragment
import myapp.com.cityin.fragment.fragmentPeoplePage.SuggestionFragment
import android.support.v7.app.AppCompatActivity
import myapp.com.cityin.adapter.ViewPagerAdapter


class PeopleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)

        val manager = childFragmentManager
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

    }
}