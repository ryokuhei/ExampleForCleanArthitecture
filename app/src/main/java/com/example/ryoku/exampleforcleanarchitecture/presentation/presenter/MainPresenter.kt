package com.example.ryoku.exampleforcleanarchitecture.presentation.presenter

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.RegisterUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.main.MainFragmentDelegate

/**
 * Created by ryoku on 2018/01/17.
 */
class MainPresenter: BasePresenter() {

    lateinit var delegate: MainFragmentDelegate
    lateinit var registerUser: RegisterUserUseCase

    fun register(user: User) {

        registerUser = RegisterUserUseCase()
        val result = registerUser.invoke(user)

        if (result) {
            delegate.gotoNextActivity()
        } else {
            delegate.showErrorMessage("db_error")
        }

    }

}
