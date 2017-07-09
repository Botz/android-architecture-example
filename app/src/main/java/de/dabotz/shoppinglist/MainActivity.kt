package de.dabotz.shoppinglist

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle

class MainActivity : LifecycleActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


    }
}
