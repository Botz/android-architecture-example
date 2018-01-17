package de.dabotz.shoppinglist

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.KodeinFragmentActivity
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance

class MainActivity : KodeinFragmentActivity() {

    override fun provideOverridingModule(): Kodein.Module = Kodein.Module {
        bind<FragmentActivity>("Activity") with instance(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
    }
}
