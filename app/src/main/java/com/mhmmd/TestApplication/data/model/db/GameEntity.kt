package com.mhmmd.TestApplication.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = GameEntity.TABLE_NAME)
data class GameEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Int? = null,
    @ColumnInfo(name = PLAYER_ONE)
    var player_one: String? = null,
    @ColumnInfo(name = PLAYER_TWO)
    var player_two: String? = null
){
    companion object {
        const val TABLE_NAME = "game_items"
        const val ID = "id"
        const val PLAYER_ONE = "player_one"
        const val PLAYER_TWO = "player_two"
    }
}