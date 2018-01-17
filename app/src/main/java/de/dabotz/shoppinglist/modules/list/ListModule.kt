package de.dabotz.shoppinglist.modules.list

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import de.dabotz.shoppinglist.models.GroceryListItemViewModel
import de.dabotz.shoppinglist.models.SelectedId

/**
 * Created by Botz on 24.09.17.
 */

fun createListModule(fragment: Fragment) = Kodein.Module {
    bind<GroceryListItemViewModel>() with provider {
        val factory = GroceryListItemViewModel.Fabric(instance())
        ViewModelProviders.of(fragment, factory)[GroceryListItemViewModel::class.java]
    }

    bind<SelectedId>() with provider {
        ViewModelProviders.of(instance<FragmentActivity>("Activity"))[SelectedId::class.java]
    }
}