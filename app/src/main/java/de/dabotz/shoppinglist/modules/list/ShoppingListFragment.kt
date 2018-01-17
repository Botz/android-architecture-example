package de.dabotz.shoppinglist.modules.list

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector
import com.github.salomonbrys.kodein.instance
import de.dabotz.shoppinglist.R
import de.dabotz.shoppinglist.models.GroceryListItem
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId
import de.dabotz.shoppinglist.modules.detail.DetailActivity
import kotlinx.android.synthetic.main.f_shopping_list.*
import java.util.*


/**
 * Created by Botz on 08.07.17.
 */
class ShoppingListFragment: Fragment(), SupportFragmentInjector {
    override val injector: KodeinInjector = KodeinInjector()

    val groceryList by lazy {
        groceryItemsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        groceryItemsRecyclerView.adapter = groceryListItemAdapter
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        groceryItemsRecyclerView.addItemDecoration(itemDecoration)
        groceryItemsRecyclerView
    }

    val groceryListItemAdapter = GroceryListItemAdapter {
        selectedViewModel.select(it.id)
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("itemId", it.id)
        startActivity(intent)
    }

    val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(p0: RecyclerView?, p1: RecyclerView.ViewHolder?, p2: RecyclerView.ViewHolder?): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
            viewModel.delete(viewModel.groceryListItems.value?.get(viewHolder.adapterPosition))
        }
    })

    val viewModel: GroceryListItemViewModel by injector.instance()
    val selectedViewModel: SelectedId by injector.instance()

    override fun provideOverridingModule() = createListModule(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initializeInjector()
        return inflater!!.inflate(R.layout.f_shopping_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(groceryList)

        viewModel.groceryListItems.observe(this, Observer { items ->
            items?.let {
                groceryListItemAdapter.data = it
            }
        })

        sendButton.setOnClickListener {
            viewModel.addItem(GroceryListItem(0,
                    groceryItemEditText.text.toString(), 1, created = Date()))
            groceryItemEditText.text.clear()
        }
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}