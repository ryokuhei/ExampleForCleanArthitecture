package com.example.ryoku.exampleforcleanarchitecture.domain.use_case

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStore
import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStoreImpl
import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.UserRepository

/**
 * Created by ryoku on 2018/01/17.
 */
class RegisterUserUseCase: BaseUseCase() {

    val repository: UserRepository = UserRepository()

    fun invoke(user: User): Boolean {

        return repository.createUser(user)
    }
}


