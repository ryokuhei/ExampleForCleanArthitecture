package com.example.ryoku.exampleforcleanarchitecture.presentation.view.main

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.presentation.presenter.MainPresenter
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.BaseFragment

/**
 * Created by ryoku on 2018/01/17.
 */
class MainFragment: Fragment(), MainFragmentDelegate {

    companion object {
        fun createInstanse(): MainFragment {

            Log.d("mainFragment","instantiate")
           return MainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("mainFragment", "onCreate")
//        presenter = MainPresenter()

    }

    var presenter: MainPresenter = MainPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        Log.d("mainFragment","onCreateView")

        return inflater?.inflate(R.layout.fragment_test, container, false)
    }


    override fun gotoNextActivity() {
    }

    override fun showErrorMessage(message: String) {
    }

}

interface MainFragmentDelegate {
    fun gotoNextActivity()
    fun showErrorMessage(message: String)
}