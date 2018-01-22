package com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.main.MainActivity

/**
 * Created by esmile_system_01 on 2018/01/22.
 */
class NextActivity : AppCompatActivity() {

    var id: Int? = null

    companion object {
        fun createIntent(context: Context, id: Int): Intent {
            return Intent(context, NextActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        this.id = intent?.getIntExtra(MainActivity.USER_ID, 0)

        if (savedInstanceState == null) {
            id?.let {
                val nextFragment = NextFragment.createInstanse(it)
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.next_fl, nextFragment)
                        .commit()
            }
        }

    }
}