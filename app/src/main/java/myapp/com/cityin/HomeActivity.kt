package myapp.com.cityin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*
import myapp.com.cityin.fragment.FavoriteFragment
import myapp.com.cityin.fragment.PeopleFragment
import myapp.com.cityin.fragment.SearchFragment
import myapp.com.cityin.fragment.UserFragment

class testActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                createFragmentOne()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                createFragmentTwo()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_people -> {
                createFragmentThree()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                createFragmentFour()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun createFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = SearchFragment()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FavoriteFragment()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentThree(){
        val transaction = manager.beginTransaction()
        val fragment = UserFragment()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentFour(){
        val transaction = manager.beginTransaction()
        val fragment = FavoriteFragment()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
