package de.dabotz.shoppinglist

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.FragmentActivityInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance

class MainActivity : AppCompatActivity(), FragmentActivityInjector {
    override val injector: KodeinInjector = KodeinInjector()

    override fun provideOverridingModule(): Kodein.Module = Kodein.Module {
        bind<FragmentActivity>("Activity") with instance(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        setContentView(R.layout.main_layout)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
