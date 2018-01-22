package com.example.ryoku.exampleforcleanarchitecture.domain.use_case

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.UserRepository

/**
 * Created by ryoku on 2018/01/22.
 */
class GetUserIdUseCase: BaseUseCase() {

    fun invoke(searchWord: User): Int? {
        var id: Int? = null

        val userRepository = UserRepository()

        val userEntityList = userRepository.searchUserList(searchWord)
        if(!userEntityList.isEmpty()) {
           id = userEntityList[0].id
        }

        return id

    }
}