package ru.fefu.activitytracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
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
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_activity -> {
                    if (activityFragment !== null)
                        supportFragmentManager.beginTransaction().show(activityFragment)
                            .commit()
                    else {
                        supportFragmentManager.beginTransaction().apply {
                            add(
                                R.id.fragmentContainerView,
                                ActivityFragment(),
                                "activityFragment"
                            )
                            commit()
                        }
                    }
                    }
                R.id.navigation_profile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, ProfileFragment()).commit()
                }
            }
            true
        }
    }
}