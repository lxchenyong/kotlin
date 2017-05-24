package com.jeff.kotliontest

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jeff.kotliontest.fragment.DashboardFragment
import com.jeff.kotliontest.fragment.HomeFragment
import com.jeff.kotliontest.fragment.NotificationsFragment
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null
    private var dashboardFragment: DashboardFragment?=null
    private var notificationFragment: NotificationsFragment?=null
    private var mToast: Toast? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                showToast(this.resources.getText(R.string.title_home) as String)
                toast(this.resources.getText(R.string.title_home) as String)
                if (homeFragment == null)
                    homeFragment = HomeFragment()
                replaceFragment(homeFragment!!)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                if (dashboardFragment == null)
                    dashboardFragment = DashboardFragment()
                replaceFragment(dashboardFragment!!)
                showToast(this.resources.getText(R.string.title_dashboard) as String, Toast.LENGTH_SHORT)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                if ( notificationFragment == null)
                    notificationFragment = NotificationsFragment()
                replaceFragment(notificationFragment!!)
                toast(this.resources.getText(R.string.title_notifications) as String)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (homeFragment == null)
            homeFragment = HomeFragment()
        replaceFragment(homeFragment!!)

    }

    override fun onResume() {
        super.onResume()


    }

    fun showToast(message: String, length: Int = Toast.LENGTH_LONG) {
        if (mToast == null) {
            mToast = Toast.makeText(this, message, length)
        } else {
            mToast!!.setText(message)
        }
        mToast!!.show()

    }

    fun replaceFragment(newFragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_fragment, newFragment)
        transaction.commit()
    }
}
