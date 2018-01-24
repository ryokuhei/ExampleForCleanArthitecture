package com.example.ryoku.exampleforcleanarchitecture.data.data_store

import com.example.ryoku.exampleforcleanarchitecture.data.data_store.realm.RealmUserDataStoreImpl
import com.example.ryoku.exampleforcleanarchitecture.domain.repository.TestDataStore

/**
 * Created by ryoku on 2018/01/24.
 */
class DataStoreFactory {

    fun create(db: DB): UserDataStore? {

        val dataStore: UserDataStore?

        when(db) {
            DB.Realm ->
                    dataStore = RealmUserDataStoreImpl()
            DB.Test ->
                    dataStore = TestDataStore()
        }

        return dataStore
    }
}

enum class DB {
    Realm,
    Test
}