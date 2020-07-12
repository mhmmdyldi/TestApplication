package com.mhmmd.TestApplication.data.repository

import com.mhmmd.TestApplication.data.local.db.DbHelper
import com.mhmmd.TestApplication.data.model.db.GameEntity
import com.mhmmd.TestApplication.data.remote.ApiHelper
import io.reactivex.Completable
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper, private val dbHelper: DbHelper) {
    fun saveGame(game: GameEntity) : Completable{
        return dbHelper.saveGame(game)
    }

    fun loadGamesList(): Single<List<GameEntity>> {
        return dbHelper.loadGameList()
    }
}