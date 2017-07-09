package de.dabotz.shoppinglist.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import de.dabotz.shoppinglist.DateConverter
import java.util.*

/**
 * Created by Botz on 05.07.17.
 */
@Entity
data class GroceryListItem(@PrimaryKey(autoGenerate = true) val id: Int,
                           var name: String = "",
                           var count: Int = 1,
                           var created: Date = Date())