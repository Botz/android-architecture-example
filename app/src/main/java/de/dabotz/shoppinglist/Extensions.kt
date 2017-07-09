package de.dabotz.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Botz on 06.07.17.
 */

fun ViewGroup.inflate(layoutRes:Int) = LayoutInflater.from(context).inflate(layoutRes, this, false)