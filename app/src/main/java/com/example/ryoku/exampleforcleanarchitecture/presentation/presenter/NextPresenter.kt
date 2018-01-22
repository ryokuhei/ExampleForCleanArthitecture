package com.example.ryoku.exampleforcleanarchitecture.presentation.presenter

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.translator.UserTranslator
import com.example.ryoku.exampleforcleanarchitecture.domain.use_case.GetUserUseCase
import com.example.ryoku.exampleforcleanarchitecture.presentation.view.naxt.NextFragmentDelegate

/**
 * Created by ryoku on 2018/01/17.
 */
class NextPresenter: BasePresenter() {

    lateinit var delegate: NextFragmentDelegate

    fun getUserData(id: Int): User? {

        val getUserUseCase = GetUserUseCase()
        val user = getUserUseCase.invoke(id)

        return user

    }

}