package com.example.ryoku.exampleforcleanarchitecture.domain.use_case

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStoreImpl
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.UserRepository

/**
 * Created by ryoku on 2018/01/17.
 */
class RegisterUserUseCase: BaseUseCase() {

    lateinit var repository: UserRepository

    fun invoke(user: User): Boolean {

        repository = UserRepository()

        return repository.createUser(user)
    }
}