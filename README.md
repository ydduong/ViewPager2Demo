# ViewPager2Demo
#### 1.实现效果
<img src = "https://img-blog.csdnimg.cn/202002121627256.jpg" width = "30%"> <img src = "https://img-blog.csdnimg.cn/20200212162854639.jpg" width = "30%"> <img src = "https://img-blog.csdnimg.cn/20200212162952674.jpg" width = "30%">
#### 2.添加依赖
```bash
implementation 'androidx.viewpager2:viewpager2:1.0.0'
implementation 'com.google.android.material:material:1.2.0-alpha04'
```
#### 3.创建fragment
<img src = "https://img-blog.csdnimg.cn/20200212163227308.png" width = "50%">

#### 4.修改布局
在activity中添加布局：（divider是分割线）
<img src = "https://img-blog.csdnimg.cn/20200212163433335.png" width = "90%">
此外手动将viewpager修改为viewpager2
```xml
//修改前：
<androidx.viewpager.widget.ViewPager
    android:id="@+id/viewPager2"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
//修改后：
<androidx.viewpager2.widget.ViewPager2
    android:id="@+id/viewPager2"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
#### 5.实现顶部导航
在MainActivity中实现：
```kotlin
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
```
