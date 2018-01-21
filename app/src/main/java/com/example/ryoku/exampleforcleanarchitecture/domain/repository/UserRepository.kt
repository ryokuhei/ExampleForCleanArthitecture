package com.example.ryoku.exampleforcleanarchitecture.domain.repository

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStore
import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User

/**
 * Created by ryoku on 2018/01/17.
 */
class UserRepository: BaseRepository() {

    lateinit var dataStore: UserDataStore

    fun createUser(user: User): Boolean {
        return dataStore.insert(user)
    }

    fun getUser(id: Int): UserEntity? {
        return dataStore.get(id)
    }
}