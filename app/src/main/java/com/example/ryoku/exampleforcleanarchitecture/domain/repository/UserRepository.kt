package com.example.ryoku.exampleforcleanarchitecture.domain.repository

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.DataStoreFactory
import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStore
import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User

/**
 * Created by ryoku on 2018/01/17.
 */
class UserRepository: BaseRepository() {

    val dataStore: UserDataStore?

    init {
        val factory = DataStoreFactory()
        dataStore = factory.create(DB.Test)
    }

    fun createUser(user: User): Boolean {
        return dataStore?.insert(user) ?: false
    }

    fun getUser(id: Int): UserEntity? {
        return dataStore?.get(id)
    }

    fun searchUserList(user: User): List<UserEntity> {
        return dataStore?.search(user) ?: emptyList()
    }
}

class TestDataStore : UserDataStore {
    val testUser = UserEntity(1,"takaka","taro",9)
    override fun get(id: Int): UserEntity? = testUser
    override fun getList(): List<UserEntity> = mutableListOf(testUser)
    override fun search(user: User): List<UserEntity> = emptyList()
                //mutableListOf(testUser)
    override fun insert(user: User): Boolean = true
    override fun update(id: Int, user: User): Boolean = true
    override fun delete(id: Int): Boolean = true
}
