package myapp.com.cityin.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import kotlinx.android.synthetic.main.fragment_people.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.fragmentPeoplePage.ActivitiesFragment
import myapp.com.cityin.fragment.fragmentPeoplePage.SuggestionFragment

class PeopleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)

        Log.i("context", "test")
        /*val manager = childFragmentManager
        val adapter = myViewPagerAdapter(manager)
        Log.i("PeopleFragment", "test")

        adapter.addFragment(ActivitiesFragment(), "one")
        adapter.addFragment(SuggestionFragment(), "two")
        viewPager.adapter
        tabs.setupWithViewPager(viewPager)*/
    }

    /*class myViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        val fragmentList: MutableList<Fragment> = ArrayList()
        val TitleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(view: Fragment, title:String){
            fragmentList.add(view)
            TitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return TitleList[position]
        }

    }*/
}