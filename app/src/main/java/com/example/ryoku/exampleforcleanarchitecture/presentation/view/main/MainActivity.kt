package com.example.ryoku.exampleforcleanarchitecture.presentation.view.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.main.MainFragment

class MainActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            Log.d("mainActivity","instantiate")
            print("companion topActivity")
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("mainActivity","onCreate")

        print("onCreate at mainActivity")

        if(savedInstanceState == null) {
            val mainFragment = MainFragment.createInstanse()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, mainFragment)
//                .add(R.id.container, Fragment())
                    .commit()
        }

    }
}
