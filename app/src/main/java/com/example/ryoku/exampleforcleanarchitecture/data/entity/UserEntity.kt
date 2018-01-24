package com.example.ryoku.exampleforcleanarchitecture.data.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ryoku on 2018/01/17.
 */
interface UserEntity {
        var id: Int
        var firstName: String
        var lastName: String
        var age: Int
}
