package com.example.carepets.database

import androidx.room.TypeConverter
import java.sql.Blob

class Converters {

    @TypeConverter
    fun fromStringToBlog(value: String?): Blob? {
        return value as Blob?
    }

    @TypeConverter
    fun fromBlogToString(blog: Blob?): String? {
        return null
    }

}