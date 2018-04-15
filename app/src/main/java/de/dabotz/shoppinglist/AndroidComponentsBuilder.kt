package de.dabotz.shoppinglist

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.dabotz.shoppinglist.modules.detail.DetailActivity
import de.dabotz.shoppinglist.modules.detail.DetailActivityModule
import de.dabotz.shoppinglist.modules.detail.DetailModule
import de.dabotz.shoppinglist.modules.detail.ShoppingItemFragment
import de.dabotz.shoppinglist.modules.list.ListModule
import de.dabotz.shoppinglist.modules.list.ShoppingListFragment

@Module
abstract class AndroidComponentsBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindAlbumDetailFragment(): ShoppingItemFragment

    @ContributesAndroidInjector(modules = [ListModule::class])
    abstract fun bindAlbumListFragment(): ShoppingListFragment
}