package com.example.ryoku.exampleforcleanarchitecture.domain.use_case

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.UserRepository
import com.example.ryoku.exampleforcleanarchitecture.domain.translator.UserTranslator

/**
 * Created by ryoku on 2018/01/18.
 */
class GetUserUseCase: BaseUseCase() {

    fun invoke(id: Int): User? {

        var user: User? = null

        val userRepository = UserRepository()
        val userTranslator = UserTranslator()

        val userEntity = userRepository.getUser(id)

        userEntity?.let {
            user = userTranslator.translate(it)
        }

        return user

    }
}