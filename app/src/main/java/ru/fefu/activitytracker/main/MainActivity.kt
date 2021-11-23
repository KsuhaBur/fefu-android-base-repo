package ru.fefu.activitytracker.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityMainBinding
import ru.fefu.activitytracker.fragments.ActivityFragment
import ru.fefu.activitytracker.fragments.FlowFragment
import ru.fefu.activitytracker.fragments.MyActivityDetailsFragment
import ru.fefu.activitytracker.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fragmentContainerView,
                    ActivityFragment(),
                    "activityFragment"
                )
                commit()
            }
        }

        binding.bottomNav.setOnNavigationItemSelectedListener {
            val activityFragment = supportFragmentManager.findFragmentByTag("activityFragment")
            val profileFragment = supportFragmentManager.findFragmentByTag("profileFragment")
            when (it.itemId) {
                R.id.navigation_activity -> {
                    if (profileFragment !== null) {
                        supportFragmentManager.beginTransaction().hide(profileFragment).commit()
                    }
                    if (activityFragment !== null) {
                        supportFragmentManager.beginTransaction().show(activityFragment).commit()
                    }
                }

                R.id.navigation_profile -> {
                    if (activityFragment !== null) {
                        supportFragmentManager.beginTransaction().hide(activityFragment).commit()
                    }
                    if (profileFragment !== null) {
                        supportFragmentManager.beginTransaction().show(profileFragment).commit()
                    } else {
                        supportFragmentManager.beginTransaction().apply {
                            add(
                                R.id.fragmentContainerView,
                                ProfileFragment(),
                                "profileFragment"
                            )
                            commit()
                        }
                    }
                }
            }
            true
        }

    }
}