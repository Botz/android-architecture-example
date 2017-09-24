package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.FragmentActivityInjector
import de.dabotz.shoppinglist.R
import de.dabotz.shoppinglist.models.SelectedId

class DetailActivity : AppCompatActivity(), FragmentActivityInjector {
    override val injector: KodeinInjector = KodeinInjector()

    val selectedViewModel by lazy {
        ViewModelProviders.of(this).get(SelectedId::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        if(resources.getBoolean(R.bool.has_two_panes)) {
            finish()
            return
        }
        selectedViewModel.select(intent.extras.getInt("itemId"))

        setContentView(R.layout.detail_layout)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
