package de.dabotz.shoppinglist.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Botz on 08.07.17.
 */
class SelectedViewModel: ViewModel() {

    val selected: MutableLiveData<GroceryListItem> = MutableLiveData()

    fun select(item: GroceryListItem) {
        selected.value = item
    }
}