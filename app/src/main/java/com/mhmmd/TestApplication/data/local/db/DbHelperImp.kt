package com.mhmmd.TestApplication.data.local.db

import com.mhmmd.TestApplication.data.model.db.GameEntity
import io.reactivex.Completable
import io.reactivex.Single

class DbHelperImp(val appDatabase: AppDatabase): DbHelper {
    override fun saveGame(game: GameEntity): Completable {
        return appDatabase.gameDao().insert(game)
    }

    override fun loadGameList(): Single<List<GameEntity>> {
        return appDatabase.gameDao().loadAll()
    }
}