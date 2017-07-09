package de.dabotz.shoppinglist

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.dabotz.shoppinglist.databinding.FShoppingItemBinding
import de.dabotz.shoppinglist.models.GroceryListItem
import de.dabotz.shoppinglist.models.SelectedViewModel

/**
 * Created by Botz on 08.07.17.
 */
class ShoppingItemFragment: LifecycleFragment() {

    val selectedViewModel by lazy {
        ViewModelProviders.of(activity).get(SelectedViewModel::class.java)
    }

    lateinit var dataBinding: FShoppingItemBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.f_shopping_item, container,false)
        dataBinding.handler = this
        return dataBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedViewModel.selected.observe(this, Observer {
            dataBinding.groceryItem = it
        })
    }

    fun increase(view:View, item:GroceryListItem) {

    }

    fun decrease(view:View, item:GroceryListItem) {

    }


}