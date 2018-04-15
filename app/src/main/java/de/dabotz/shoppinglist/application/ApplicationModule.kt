package de.dabotz.shoppinglist.application

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.database.MIGRATION_1_2
import javax.inject.Singleton


@Module
object ApplicationModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideDatabase(application: ShoppingListApplication): AppDatabase =
            Room.databaseBuilder(application , AppDatabase::class.java, "grocery-db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build()

}