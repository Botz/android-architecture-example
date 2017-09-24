package de.dabotz.shoppinglist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.android.FragmentActivityInjector

class MainActivity : AppCompatActivity(), FragmentActivityInjector {
    override val injector: KodeinInjector = KodeinInjector()

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
