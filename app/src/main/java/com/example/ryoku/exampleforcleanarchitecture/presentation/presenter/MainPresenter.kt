package com.example.ryoku.exampleforcleanarchitecture.presentation.presenter

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.GetUserIdUseCase
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.GetUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.RegisterUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.SearchUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.main.MainFragmentDelegate

/**
 * Created by ryoku on 2018/01/17.
 */
class MainPresenter: BasePresenter() {

    lateinit var delegate: MainFragmentDelegate

    fun register(user: User) {

        val registerUser = RegisterUserUseCase()
        val result = registerUser.invoke(user)

        var id: Int? = null

        if (result) {
            val getUserIdUseCase = GetUserIdUseCase()
            id = getUserIdUseCase.invoke(user)
        }

        if(id != null) {
            delegate.gotoNextActivity(id)
        } else {
            delegate.showErrorMessage("db_error")
        }

    }

}
