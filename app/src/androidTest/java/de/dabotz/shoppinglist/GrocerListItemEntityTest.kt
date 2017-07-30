package de.dabotz.shoppinglist

import android.arch.lifecycle.Observer
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.models.GroceryListItem
import org.junit.After
import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

/**
 * Created by Botz on 30.07.17.
 */
class GrocerListItemEntityTest {
    val context = InstrumentationRegistry.getTargetContext()
    val db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    val dao = db.groceryListItemDao()

    @After
    fun cleanUp() {
        db.close()
    }

    @Test
    fun writeAndReadAsList() {
        val item = GroceryListItem(0, "Pizza", 2, 10.9, Date())
        dao.add(item)

        val results = dao.getAllGroceryListItems()

        results.observeForever { items -> assertThat(items!![0], equalTo(item))}
    }
}