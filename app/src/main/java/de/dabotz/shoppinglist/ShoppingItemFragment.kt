package de.dabotz.shoppinglist

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.dabotz.shoppinglist.databinding.FShoppingItemBinding
import de.dabotz.shoppinglist.models.GroceryListItem
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId

/**
 * Created by Botz on 08.07.17.
 */
class ShoppingItemFragment: LifecycleFragment() {

    val selectedId by lazy {
        ViewModelProviders.of(activity).get(SelectedId::class.java)
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(GroceryListItemViewModel::class.java)
    }

    lateinit var dataBinding: FShoppingItemBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.f_shopping_item, container,false)
        dataBinding.handler = this
        return dataBinding.root
    }

    var selectedViewModel: LiveData<GroceryListItem>? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedId.selected.observe(this, Observer {
            println("selected observer $it")

            selectedViewModel?.removeObservers(this)

            selectedViewModel = viewModel.find(it!!)
            selectedViewModel?.observe(this, Observer {
                println("viewModel observer ${it?.id}")
                dataBinding.groceryItem = it
            })

        })
    }

    fun increase(view:View, item:GroceryListItem) {
        println("increase ${item.id}")
        item.count++
        viewModel.update(item)
    }

    fun decrease(view:View, item:GroceryListItem) {
        println("decrease ${item.id}")
        item.count--
        viewModel.update(item)
    }


}