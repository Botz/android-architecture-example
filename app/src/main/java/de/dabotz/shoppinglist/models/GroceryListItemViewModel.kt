package de.dabotz.shoppinglist.models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import de.dabotz.shoppinglist.AppDatabase

/**
 * Created by Botz on 05.07.17.
 */
class GroceryListItemViewModel(application: Application): AndroidViewModel(application) {

    val appDataBase = AppDatabase.create(application)
    val groceryListItems = appDataBase.groceryListItemDao().getAllGroceryListItems()

    fun addItem(groceryListItem: GroceryListItem) = appDataBase.groceryListItemDao().add(groceryListItem)
    fun delete(groceryListItem: GroceryListItem?) = appDataBase.groceryListItemDao().delete(groceryListItem)
    fun find(id : Int) = appDataBase.groceryListItemDao().find(id)
    fun update(groceryListItem : GroceryListItem) = appDataBase.groceryListItemDao().update(groceryListItem)
}