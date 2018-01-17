package de.dabotz.shoppinglist.modules.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.FragmentActivityInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import de.dabotz.shoppinglist.R
import de.dabotz.shoppinglist.models.SelectedId

class DetailActivity : AppCompatActivity(), FragmentActivityInjector {
    override val injector: KodeinInjector = KodeinInjector()

    override fun provideOverridingModule() = Kodein.Module {
        bind<FragmentActivity>("Activity") with instance(this@DetailActivity)
    }

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
