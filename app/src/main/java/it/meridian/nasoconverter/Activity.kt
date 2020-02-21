package it.meridian.nasoconverter

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentActivity

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
}