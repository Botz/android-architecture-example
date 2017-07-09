package de.dabotz.shoppinglist

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import de.dabotz.shoppinglist.models.GroceryListItem

/**
 * Created by Botz on 05.07.17.
 */
@Dao
interface GroceryListItemDAO {
    @Query("select * from grocerylistitem")
    fun  getAllGroceryListItems() : LiveData<List<GroceryListItem>>

    @Insert
    fun add(item: GroceryListItem)

    @Delete
    fun delete(groceryListItem: GroceryListItem?)

}