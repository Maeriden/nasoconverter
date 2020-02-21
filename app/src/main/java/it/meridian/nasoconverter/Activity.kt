package it.meridian.nasoconverter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.lang.IllegalArgumentException


class Activity
    : FragmentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        val viewPager : ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = AdapterViewPager(this, this.supportFragmentManager)

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }


    private class AdapterViewPager(private val context: Context, fragmentManager: FragmentManager)
        : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
    {
        override fun getItem(position: Int) : Fragment = when(position) {
            0 -> FragmentMoney2Coins()
            1 -> FragmentCoins2Money()
            else -> throw IllegalArgumentException()
        }

        override fun getPageTitle(position: Int) : CharSequence? = when(position) {
            0 -> this.context.getString(R.string.tab_title_0)
            1 -> this.context.getString(R.string.tab_title_1)
            else -> throw IllegalArgumentException()
        }

        override fun getCount() : Int = 2
    }
}