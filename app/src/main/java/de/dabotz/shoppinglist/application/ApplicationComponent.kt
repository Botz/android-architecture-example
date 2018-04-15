package de.dabotz.shoppinglist.application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import de.dabotz.shoppinglist.AndroidComponentsBuilder
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            AndroidComponentsBuilder::class
        ]
)
interface ApplicationComponent: AndroidInjector<ShoppingListApplication> {
    @dagger.Component.Builder
    abstract class Builder: AndroidInjector.Builder<ShoppingListApplication>()
}