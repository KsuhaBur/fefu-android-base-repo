package ru.fefu.activitytracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.fefu.activitytracker.databinding.ActivityMainBinding
import ru.fefu.activitytracker.fragments.ActivityFragment
import ru.fefu.activitytracker.fragments.MyActivityFragment
import ru.fefu.activitytracker.fragments.ProfileFragment
import java.lang.reflect.Array.newInstance

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activityFragment = supportFragmentManager.findFragmentByTag("activityFragment")
        val profileFragment = supportFragmentManager.findFragmentByTag("profileFragment")

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_activity -> {
                    if (activityFragment !== null) {
                        if (profileFragment !== null) {
                            supportFragmentManager.beginTransaction().hide(profileFragment).commit()
                        }
                        supportFragmentManager.beginTransaction().show(activityFragment)
                            .commit()
                    }
                    else {
                        if (profileFragment !== null) {
                            supportFragmentManager.beginTransaction().hide(profileFragment).commit()
                        }
                        supportFragmentManager.beginTransaction().apply {
                            replace(
                                R.id.fragmentContainerView,
                                ActivityFragment(),
                                "activityFragment"
                            )
                            commit()
                        }
                    }
                }
                R.id.navigation_profile -> {
                    if (profileFragment !== null) {
                        if (activityFragment !== null) {
                            supportFragmentManager.beginTransaction().hide(activityFragment)
                                .commit()
                        }
                        supportFragmentManager.beginTransaction().show(profileFragment)
                            .commit()
                    }

                    else {
                        if (activityFragment !== null) {
                            supportFragmentManager.beginTransaction().hide(activityFragment)
                                .commit()
                        }
                        supportFragmentManager.beginTransaction().apply {
                            replace(
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