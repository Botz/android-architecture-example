package de.dabotz.shoppinglist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import de.dabotz.shoppinglist.models.GroceryListItem

/**
 * Created by Botz on 05.07.17.
 */
@Database(entities = arrayOf(GroceryListItem::class), version = 2)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {
    private object Holder { var INSTANCE: AppDatabase? = null }

    companion object {
        fun create(context: Context) : AppDatabase {
            if (Holder.INSTANCE == null) {
                Holder.INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "grocery-db")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build()
            }

            return Holder.INSTANCE!!
        }
    }

    abstract fun groceryListItemDao() : GroceryListItemDAO
}
