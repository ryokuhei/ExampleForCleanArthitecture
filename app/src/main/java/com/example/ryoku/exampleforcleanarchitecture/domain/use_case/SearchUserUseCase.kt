package com.example.ryoku.exampleforcleanarchitecture.domain.use_case

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.UserRepository
import com.example.ryoku.exampleforcleanarchitecture.domain.translator.UserTranslator

/**
 * Created by ryoku on 2018/01/22.
 */
class SearchUserUseCase: BaseUseCase() {

    fun invoke(searchWord: User): User? {
        var user: User? = null

        val userRepository = UserRepository()
        val userTranslator = UserTranslator()

        val userEntityList = userRepository.searchUserList(searchWord)
        userEntityList[0].let {
            user = userTranslator.translate(it)
        }

        return user

    }
}