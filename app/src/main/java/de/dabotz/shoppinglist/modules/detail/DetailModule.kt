package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId
import de.dabotz.shoppinglist.modules.list.ShoppingListFragment

/**
 * Created by Botz on 24.09.17.
 */
@Module
object DetailModule {

    @JvmStatic
    @Provides
    fun provideGroceryListItemViewModel(fragment: ShoppingItemFragment, db: AppDatabase)
            = ViewModelProviders.of(fragment, GroceryListItemViewModel.Fabric(db))[GroceryListItemViewModel::class.java]

    @JvmStatic
    @Provides
    fun provideSelectedIdViewModel(fragment: ShoppingItemFragment)
            = ViewModelProviders.of(fragment.activity!!)[SelectedId::class.java]
}