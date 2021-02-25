package com.pratisandhi.survey.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.pratisandhi.survey.databinding.ActivitySurveyBinding
import com.pratisandhi.survey.utils.SectionsPagerAdapter
import com.sample.viewbinding.activity.viewBinding

class Survey : AppCompatActivity() {

    private val binding: ActivitySurveyBinding by viewBinding()
    var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Setup viewpager and tablayout
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)
        binding.viewPager.adapter = sectionsPagerAdapter

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currentPage = position;
                if (currentPage == 0) {
                    binding.back.isEnabled = false
                    binding.next.isEnabled = true
                    binding.back.visibility = View.INVISIBLE
                } else if (currentPage == 5) {
                    binding.back.isEnabled = true
                    binding.next.isEnabled = true
                    binding.back.visibility = View.VISIBLE
                    binding.next.text = "Submit"
                } else {
                    binding.back.isEnabled = true
                    binding.next.isEnabled = true
                    binding.back.visibility = View.VISIBLE
                    binding.next.text = "NEXT"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        binding.next.setOnClickListener {
            binding.viewPager.currentItem += 1
        }

        binding.back.setOnClickListener {
            binding.viewPager.currentItem -= 1
        }

    }
}