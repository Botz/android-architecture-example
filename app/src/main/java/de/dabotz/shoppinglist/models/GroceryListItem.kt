package de.dabotz.shoppinglist.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by Botz on 05.07.17.
 */
@Entity
data class GroceryListItem(@PrimaryKey(autoGenerate = true) val id: Int,
                           var name: String = "",
                           var count: Int = 1,
                           var price: Double = 1.0,
                           var created: Date = Date())