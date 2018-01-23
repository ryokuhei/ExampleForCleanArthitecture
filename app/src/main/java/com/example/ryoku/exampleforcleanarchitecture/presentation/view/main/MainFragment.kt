package com.example.ryoku.exampleforcleanarchitecture.presentation.view.main

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.presentation.presenter.MainPresenter

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
        view?.findViewById<RelativeLayout>(R.id.layout_rl).setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    // createUser
    override fun onClick(view: View?) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)


        when(view?.id) {
            R.id.register_button -> {
                val firstName = firstNameET.text.toString()
                val lastName = lastNameET.text.toString()
                val ageString =ageET.text.toString()
                if (!firstName.isEmpty() && !lastName.isEmpty() && !ageString.isEmpty()) {
                    val age = Integer.parseInt(ageString)
                    val user = User(firstName, lastName, age)

                    this.presenter.register(user)
                }
            }
            R.id.layout_rl -> {
                Log.d("layout", "clicked")
//                if(view != null) {
//                    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                    imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
//                    view.clearFocus()
//                }
            }
            else -> print("non_click")
        }
    }

    // result create success
    override fun gotoNextActivity(id: Int) {
        delegate.gotoNextActivity(id)
    }

    // result create failure
    override fun showErrorMessage(message: String) {
        val alertDialog = AlertDialog.Builder(activity)
        alertDialog.setTitle("Error")
        alertDialog.setMessage(message)
        alertDialog.create()
        alertDialog.show()
    }
}

interface MainFragmentDelegate {
    fun gotoNextActivity(id: Int)
    fun showErrorMessage(message: String)
}