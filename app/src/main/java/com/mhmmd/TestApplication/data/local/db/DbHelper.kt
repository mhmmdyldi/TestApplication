package com.mhmmd.TestApplication.data.local.db

import com.mhmmd.TestApplication.data.model.db.GameEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DbHelper {
    fun saveGame(game: GameEntity) : Completable
    fun loadGameList(): Single<List<GameEntity>>
}