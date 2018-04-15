package de.dabotz.shoppinglist.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Botz on 24.09.17.
 */
class ShoppingListApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }
}