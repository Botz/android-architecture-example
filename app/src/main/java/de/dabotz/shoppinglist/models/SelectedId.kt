package de.dabotz.shoppinglist.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Botz on 08.07.17.
 */
class SelectedId : ViewModel() {

    val selected: MutableLiveData<Int> = MutableLiveData()

    fun select(id: Int) {
        selected.value = id
    }
}