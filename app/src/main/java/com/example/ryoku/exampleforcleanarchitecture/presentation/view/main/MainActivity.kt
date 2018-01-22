package com.example.ryoku.exampleforcleanarchitecture.presentation.view.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt.NextActivity

class MainActivity : AppCompatActivity(), MainActivityDelegate {

    companion object {
        val USER_ID = "id"

        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            val mainFragment = MainFragment.createInstanse()
            mainFragment.delegate = this
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.main_fl, mainFragment)
                    .commit()
        }

    }

    // result create success
    override fun gotoNextActivity(id: Int) {
        val intent = NextActivity.createIntent(this, id)
        intent.putExtra(USER_ID, id)
        startActivity(intent)
    }

}

interface MainActivityDelegate {
    fun gotoNextActivity(id: Int)
}
