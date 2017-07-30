package de.dabotz.shoppinglist.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
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

    @Query("select * from grocerylistitem where id=:id limit 1")
    fun find(id: Int): LiveData<GroceryListItem>

    @Update
    fun update(groceryListItem: GroceryListItem?)
}