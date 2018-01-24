package com.example.ryoku.exampleforcleanarchitecture.data.entity

import com.example.ryoku.exampleforcleanarchitecture.domain.model.User
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ryoku on 2018/01/24.
 */
data class RealmUserEntity (
        @PrimaryKey
        override var id: Int,
        override var firstName: String,
        override var lastName: String,
        override var age: Int
): RealmObject(), UserEntity {

    fun setObject(user: User) {
        user.firstName?.let {
            this.firstName = it
        }
        user.lastName?.let {
            this.lastName = it
        }
        user.age?.let {
            this.age = it
        }
    }
}
