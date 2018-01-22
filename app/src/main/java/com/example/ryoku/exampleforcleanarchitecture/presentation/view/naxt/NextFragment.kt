package com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.presentation.presenter.NextPresenter
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.BaseFragment
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.main.MainActivity

/**
 * Created by ryoku on 2018/01/17.
 */
class NextFragment: BaseFragment(), NextFragmentDelegate, View.OnClickListener {

    lateinit var bundle: Bundle

    var id: Int? = null

    lateinit var nameTV: TextView
    lateinit var ageTV: TextView

    val presenter: NextPresenter = NextPresenter()

    companion object {
        val USER_ID = "id"
        fun createInstanse(id: Int): NextFragment {
            Log.d("NextFragment-ID","${id.toString()}")
            val bundle = Bundle()
            bundle.putInt(USER_ID, id)

            val nextFragment = NextFragment()
            nextFragment.arguments = bundle

            return nextFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         view?.apply {
            nameTV = this.findViewById<TextView>(R.id.name_tv) as TextView
            ageTV  = this.findViewById<TextView>(R.id.age_tv) as TextView

        }


        view?.findViewById<Button>(R.id.register_button)?.setOnClickListener(this)

        val bundle: Bundle = arguments
        id = bundle.getInt(USER_ID)

        Log.d("id","${id.toString()}")


        var user: User?
        id?.let {
            presenter.delegate = this

            user = presenter.getUserData(it)

            val name = "${user?.firstName} ${user?.lastName}"
            Log.d("firstName","${user?.firstName}")
            Log.d("Name","${name}")
            nameTV.text=name
            ageTV.text=Integer.toString(user?.age!!) ?: ""
        }

    }

    override fun showUser(user: User) {
        val name = user?.firstName + user?.lastName
        this.nameTV.setText(name)
        this.ageTV.setText(user.age.toString())
    }

    override fun onClick(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface NextFragmentDelegate {
    fun showUser(user: User)
}