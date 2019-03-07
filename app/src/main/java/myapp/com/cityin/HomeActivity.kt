package myapp.com.cityin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import myapp.com.cityin.fragment.FavoriteFragment
import myapp.com.cityin.fragment.PeopleFragment
import myapp.com.cityin.fragment.SearchFragment
import myapp.com.cityin.fragment.UserFragment

class HomeActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                test(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                test(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_people -> {
                test(PeopleFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                test(UserFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        test(SearchFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun test(view: Fragment){
        val transaction = manager.beginTransaction()
        val fragment = view
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
