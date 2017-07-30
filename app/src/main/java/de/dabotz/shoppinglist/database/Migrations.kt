package de.dabotz.shoppinglist.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

/**
 * Created by Botz on 30.07.17.
 */

val MIGRATION_1_2 = object: Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE grocerylistitem ADD COLUMN price REAL")
    }
}
