package de.dabotz.shoppinglist

import android.app.Application
import android.arch.persistence.room.Room
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.eagerSingleton
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.database.MIGRATION_1_2

/**
 * Created by Botz on 24.09.17.
 */
class ShoppingListApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        bind<AppDatabase>() with eagerSingleton {
            Room.databaseBuilder(this@ShoppingListApplication, AppDatabase::class.java, "grocery-db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build() }
    }
}