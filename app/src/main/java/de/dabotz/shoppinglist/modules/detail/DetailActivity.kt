package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import de.dabotz.shoppinglist.R
import de.dabotz.shoppinglist.models.SelectedId
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var selectedViewModel: SelectedId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(resources.getBoolean(R.bool.has_two_panes)) {
            finish()
            return
        }
        selectedViewModel.select(intent.extras.getInt("itemId"))

        setContentView(R.layout.detail_layout)
    }
}
