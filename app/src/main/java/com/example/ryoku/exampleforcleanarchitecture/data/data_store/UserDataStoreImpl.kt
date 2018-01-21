package com.example.ryoku.exampleforcleanarchitecture.data.data_store

import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User

/**
 * Created by ryoku on 2018/01/17.
 */
class UserDataStoreImpl : UserDataStore {

    override fun get(id: Int): UserEntity? {
        return null
    }

    override fun getList(): List<UserEntity> {
        return emptyList()
    }

    override fun search(user: User): List<UserEntity> {
        return emptyList()
    }

    override fun insert(user: User): Boolean {
        return true
    }

    override fun update(id: Int, user: User): Boolean {
        return true
    }

    override fun delete(id: Int): Boolean {
        return true
    }
}