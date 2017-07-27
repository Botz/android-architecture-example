package de.dabotz.shoppinglist

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId

class DetailActivity : LifecycleActivity() {

    val selectedViewModel by lazy {
        ViewModelProviders.of(this).get(SelectedId::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(resources.getBoolean(R.bool.has_two_panes)) {
            finish()
            return
        }
        selectedViewModel.select(intent.extras.getInt("itemId"))

        setContentView(R.layout.detail_layout)
    }
}
