package it.meridian.nasoconverter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.lang.IllegalArgumentException


class AdapterViewPager(private val context: Context, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    // getItem is called to instantiate the fragment for the given page
    override fun getItem(position: Int) : Fragment = when(position)
    {
        0 -> FragmentMoney2Coins()
        1 -> FragmentCoins2Money()
        else -> throw IllegalArgumentException()
    }

    override fun getPageTitle(position: Int) : CharSequence? = when(position)
    {
        0 -> this.context.getString(R.string.tab_title_0)
        1 -> this.context.getString(R.string.tab_title_1)
        else -> throw IllegalArgumentException()
    }

    override fun getCount() : Int = 2
}