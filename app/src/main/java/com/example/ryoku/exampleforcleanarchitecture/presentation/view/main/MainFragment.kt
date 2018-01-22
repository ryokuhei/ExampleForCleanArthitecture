package com.example.ryoku.exampleforcleanarchitecture.presentation.view.main

import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.presentation.presenter.MainPresenter
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt.NextActivity

/**
 * Created by ryoku on 2018/01/17.
 */
class MainFragment: Fragment(), MainFragmentDelegate, View.OnClickListener {

    val presenter: MainPresenter = MainPresenter()
    lateinit var delegate: MainActivityDelegate

    lateinit var firstNameET: EditText
    lateinit var lastNameET: EditText
    lateinit var ageET: EditText

    companion object {
        fun createInstanse(): MainFragment {
           return MainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.presenter.delegate = this
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstNameET = view?.findViewById<EditText>(R.id.firstName_editText) as EditText
        lastNameET = view?.findViewById<EditText>(R.id.lastName_editText) as EditText
        ageET = view?.findViewById<EditText>(R.id.age_editText) as EditText

        view?.findViewById<Button>(R.id.register_button).setOnClickListener(this)
    }

    // createUser
    override fun onClick(view: View?) {
        Log.d("mainFragment","onClick")


        val firstName = firstNameET.text.toString()
        val lastName = lastNameET.text.toString()
        val age = ageET.text.toString().toInt()
        val user = User(firstName,lastName, age)

        Log.d("click id",view?.id.toString())
        when(view?.id) {
            R.id.register_button ->
                this.presenter.register(user)
            else ->
                print("non_click")
        }
    }


    // result create success
    override fun gotoNextActivity(id: Int) {
        delegate.gotoNextActivity(id)
    }

    // result create failure
    override fun showErrorMessage(message: String) {
        Log.d("createUser","false: ${message}")
    }

}

interface MainFragmentDelegate {
    fun gotoNextActivity(id: Int)
    fun showErrorMessage(message: String)
}