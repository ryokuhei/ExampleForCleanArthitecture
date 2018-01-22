package com.example.ryoku.exampleforcleanarchitecture.domain.translator

import com.example.ryoku.exampleforcleanarchitecture.data.entity.UserEntity
import com.example.ryoku.exampleforcleanarchitecture.domain.model.User

/**
 * Created by ryoku on 2018/01/18.
 */
class UserTranslator: BaseTranslator() {

    fun translate(userEntity: UserEntity): User {
        return User(userEntity.firstName, userEntity.lastName, userEntity.age)
    }
}