package de.dabotz.shoppinglist.models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import de.dabotz.shoppinglist.database.AppDatabase

/**
 * Created by Botz on 05.07.17.
 */
class GroceryListItemViewModel(val appDataBase: AppDatabase): ViewModel() {

    val groceryListItems = appDataBase.groceryListItemDao().getAllGroceryListItems()

    fun addItem(groceryListItem: GroceryListItem) = appDataBase.groceryListItemDao().add(groceryListItem)
    fun delete(groceryListItem: GroceryListItem?) = appDataBase.groceryListItemDao().delete(groceryListItem)
    fun find(id : Int) = appDataBase.groceryListItemDao().find(id)
    fun update(groceryListItem : GroceryListItem) = appDataBase.groceryListItemDao().update(groceryListItem)

    class Fabric(val appDataBase: AppDatabase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>?) : T = GroceryListItemViewModel(appDataBase) as T
    }
}