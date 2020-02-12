package com.example.viewpager2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2demo.fragment.FirstFragment
import com.example.viewpager2demo.fragment.SecondFragment
import com.example.viewpager2demo.fragment.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //添加适配器
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                //告诉viewPager有几个页面
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                //每一个位置要创建哪一个view给它
                return when(position) {
                    0 -> FirstFragment()
                    1 -> SecondFragment()
                    else -> ThirdFragment()
                }
            }
        }

        //将tabLayout与viewPager关联起来
        TabLayoutMediator(tabLayout, viewPager2){tab, position ->
            when(position) {
                0 -> tab.text = "First"
                1 -> tab.text = "Second"
                else -> tab.text = "Third"
            }
        }.attach()
    }
}
