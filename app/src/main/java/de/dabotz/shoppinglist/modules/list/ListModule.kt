package de.dabotz.shoppinglist.modules.list

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerFragment
import de.dabotz.shoppinglist.database.AppDatabase
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId

/**
 * Created by Botz on 24.09.17.
 */

@Module
object ListModule {

    @JvmStatic
    @Provides
    fun provideGroceryListItemViewModel(fragment: ShoppingListFragment, db: AppDatabase)
        = ViewModelProviders.of(fragment, GroceryListItemViewModel.Fabric(db))[GroceryListItemViewModel::class.java]

    @JvmStatic
    @Provides
    fun provideSelectedIdViewModel(fragment: ShoppingListFragment)
        = ViewModelProviders.of(fragment.activity!!)[SelectedId::class.java]
}