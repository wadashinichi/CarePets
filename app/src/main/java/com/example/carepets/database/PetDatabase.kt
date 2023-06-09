package com.example.carepets.database

import android.content.Context
import androidx.room.*

@Database(entities = [Pet::class, PetWeight::class, PetHeight::class], version = 2)
@TypeConverters(Converters::class)
abstract class PetDatabase : RoomDatabase() {

    abstract fun petDao(): PetDao
    abstract fun weightDao(): PetWeightDao
    abstract fun heightDao(): PetHeightDao

    companion object {

        @Volatile
        private var INSTANCE: PetDatabase? = null

        fun getInstance(context: Context): PetDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PetDatabase::class.java,
                        "pet_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
                return instance
            }
        }
    }
}