package com.mhmmd.TestApplication.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhmmd.TestApplication.data.local.db.dao.GameDao
import com.mhmmd.TestApplication.data.model.db.GameEntity

@Database(entities = [GameEntity::class], version = DB_VERSION)
abstract class AppDatabase: RoomDatabase(){
    abstract fun gameDao(): GameDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

const val DB_VERSION = 1
const val DB_NAME = "AppDatabase.db"