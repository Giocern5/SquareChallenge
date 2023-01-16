package com.example.employeedirectory

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import employeefeed.EmployeeFeedFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val employeeFeedFragment = EmployeeFeedFragment()
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container, employeeFeedFragment,
                EmployeeFeedFragment.TAG
            )
            .commit()
    }
}