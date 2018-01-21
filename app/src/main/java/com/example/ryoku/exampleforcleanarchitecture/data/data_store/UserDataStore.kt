package com.example.ryoku.exampleforcleanarchitecture.data.data_store

import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User

/**
 * Created by ryoku on 2018/01/17.
 */
interface UserDataStore {

    fun get(id: Int): UserEntity?
    fun getList(): List<UserEntity>
    fun search(user: User): List<UserEntity>
    fun insert(user: User): Boolean
    fun update(id: Int, user: User): Boolean
    fun delete(id: Int): Boolean

}