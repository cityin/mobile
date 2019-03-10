package myapp.com.cityin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_people.*
import myapp.com.cityin.R
import android.support.v7.app.AppCompatActivity
import myapp.com.cityin.adapter.ViewPagerAdapter
import myapp.com.cityin.fragment.fragmentPeoplePage.ActivitiesFragment
import myapp.com.cityin.fragment.fragmentPeoplePage.SuggestionFragment


class PeopleFragment : Fragment() {

    lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)

    }

    override fun onStart() {
        super.onStart()
        val manager = childFragmentManager

        adapter = ViewPagerAdapter(manager)
        adapter.addFragments(SuggestionFragment(), "Suggestion")
        adapter.addFragments(ActivitiesFragment(),"Activités")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
    }
}