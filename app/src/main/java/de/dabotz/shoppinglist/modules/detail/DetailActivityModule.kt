package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import de.dabotz.shoppinglist.models.SelectedId

@Module
object DetailActivityModule {

    @JvmStatic
    @Provides
    fun provideSelectedIdViewModel(activity: DetailActivity)
            = ViewModelProviders.of(activity)[SelectedId::class.java]
}