package de.dabotz.shoppinglist

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by Botz on 05.07.17.
 */
class DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return  date?.let { it.time }
    }
}