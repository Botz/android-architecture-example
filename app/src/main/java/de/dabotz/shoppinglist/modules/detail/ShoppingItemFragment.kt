package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector
import com.github.salomonbrys.kodein.instance
import de.dabotz.shoppinglist.R
import de.dabotz.shoppinglist.databinding.FShoppingItemBinding
import de.dabotz.shoppinglist.models.GroceryListItem
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId

/**
 * Created by Botz on 08.07.17.
 */
class ShoppingItemFragment: Fragment(), SupportFragmentInjector {
    override val injector: KodeinInjector = KodeinInjector()


    val viewModel: GroceryListItemViewModel by injector.instance()
    val selectedId: SelectedId by injector.instance()

    override fun provideOverridingModule() = createDetailModule(this)

    lateinit var dataBinding: FShoppingItemBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initializeInjector()
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.f_shopping_item, container,false)
        dataBinding.handler = this
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Transformations.switchMap(selectedId.selected) { selectedId ->
            viewModel.find(selectedId)
        }?.observe(this, Observer {
            println("viewModel observer ${it?.id}")
            dataBinding.groceryItem = it
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

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}