package com.example.ryoku.exampleforcleanarchitecture.data.data_store.realm

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.UserDataStore
import com.example.ryoku.exampleforcleanarchitecture.data.entity.RealmUserEntity
import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by ryoku on 2018/01/24.
 */
class RealmUserDataStoreImpl: UserDataStore {

    val realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }

    fun getMaxPrimaryKey(): Int {
        var primaryKey = 1
        realm.where(RealmUserEntity::class.java).max("id").let {
            primaryKey = it.toInt()
        }

        return primaryKey
    }


    override fun get(id: Int): UserEntity? {

        val userEnity  = realm.where(RealmUserEntity::class.java).equalTo("id", id).findFirst()
        return userEnity as UserEntity

    }
    override fun getList(): List<UserEntity> {
        val userList = realm.where(RealmUserEntity::class.java).findAll()
        return userList.toList()
    }
    override fun search(user: User): List<UserEntity> {

        val userList = realm.where(RealmUserEntity::class.java)

        user.firstName.let {
            userList.equalTo("firstName", it)
        }

        user.lastName.let {
            userList.equalTo("lastName", it)
        }

        user.age.let {
            userList.equalTo("age", it)
        }

        TODO()
        return emptyList()


    }

    override fun insert(user: User): Boolean {

        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {

            val userEntity = realm.createObject(RealmUserEntity::class.java)
            userEntity.id = this.getMaxPrimaryKey()
            userEntity.setObject(user)

            realm.copyToRealm(userEntity)
        }

        return true


    }
    override fun update(id: Int, user: User): Boolean {

        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val userEntity  = realm.where(RealmUserEntity::class.java).equalTo("id", id).findFirst()
            userEntity.setObject(user)
            realm.copyToRealm(userEntity)
        }

        return true
    }

    override fun delete(id: Int): Boolean {

        TODO()
        realm.executeTransaction {
            val userEntity = realm.where(RealmUserEntity::class.java).equalTo("id", id).findFirst()
//            userEntity
        }
        return true

    }

}