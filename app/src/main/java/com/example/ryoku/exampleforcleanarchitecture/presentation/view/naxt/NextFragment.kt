package com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ryoku.exampleforcleanarchitecture.R
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.GetUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.presentation.presenter.NextPresenter
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_next.view.*

/**
 * Created by ryoku on 2018/01/17.
 */
class NextFragment: BaseFragment(), NextFragmentDelegate {

    lateinit var bundle: Bundle

    lateinit var name: TextView
    lateinit var age: TextView

    lateinit var presenter: NextPresenter

    companion object {
        fun createInstanse(id: Int): NextFragment {
            val bundle = Bundle()
            bundle.putInt("id", id)

            val nextFragment = NextFragment()
            nextFragment.bundle = bundle

            return nextFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view?.apply {
            name = this.findViewById<TextView>(R.id.name_next) as TextView
            age  = this.findViewById<TextView>(R.id.age_next) as TextView
        }
//        name = view?.findViewById<TextView>(R.id.name_next) as TextView
//        age  = view?.findViewById<TextView>(R.id.age_next) as TextView

        val id = savedInstanceState?.getInt("id")


        var user: User?
        id?.let {
            presenter = NextPresenter()
            presenter.delegate = this

            user = presenter.getUserData(it)

            name.setText(user?.name ?: "")
            age.setText(Integer.toString(user?.age!!) ?: "")
        }




    }

    override fun showUser(user: User) {
        this.name.setText(user.name)
        this.age.setText(user.age)
    }

}

interface NextFragmentDelegate {
    fun showUser(user: User)
}