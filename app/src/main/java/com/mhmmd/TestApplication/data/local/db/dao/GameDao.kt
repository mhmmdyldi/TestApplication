package com.mhmmd.TestApplication.data.local.db.dao

import androidx.room.*
import com.mhmmd.TestApplication.data.model.db.GameEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GameDao {
    @Query("SELECT * FROM ${GameEntity.TABLE_NAME}")
    fun loadAll(): Single<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg game: GameEntity): Completable

    @Delete
    fun delete(game: GameEntity): Completable

    @Update
    fun update(vararg game: GameEntity)
}