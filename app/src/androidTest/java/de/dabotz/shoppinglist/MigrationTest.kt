package de.dabotz.shoppinglist

import android.app.Instrumentation
import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory
import android.arch.persistence.room.testing.MigrationTestHelper
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.database.MIGRATION_1_2
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Botz on 30.07.17.
 */

@RunWith(AndroidJUnit4::class)
class MigrationTest {
    private val TEST_DB = "migration-test"

    @Rule @JvmField
    val helper = MigrationTestHelper(InstrumentationRegistry.getInstrumentation(),
            AppDatabase::class.java.canonicalName,
            FrameworkSQLiteOpenHelperFactory())

    @Test
    fun migrateVersion1to2() {
        var db = helper.createDatabase(TEST_DB, 1)

        db.execSQL("INSERT INTO grocerylistitem VALUES (1, 'Test', 2, 100)")

        db.close()

        db = helper.runMigrationsAndValidate(TEST_DB, 2, true, MIGRATION_1_2)

        db.close()
    }
}