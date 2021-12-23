package com.gaaan.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gaaan.retrofit.application.App.Companion.navigationHolder
import com.gaaan.retrofit.application.App.Companion.router
import com.gaaan.retrofit.users.UsersScreen
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.navigateTo(UsersScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }
}