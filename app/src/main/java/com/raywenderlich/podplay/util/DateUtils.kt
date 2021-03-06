package com.raywenderlich.podplay.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    // Format a string that the JSON serves
    fun jsonDateToShortDate(jsonDate: String?): String {
        if (jsonDate == null) {
            return "-"
        }

        // Creates a simpleDateFormat following this pattern
        val inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE)
        // The date should be transformed to an object to be passed to last function
        val date = inFormat.parse(jsonDate) ?: return "-"
        // Get the format to be shown on screen
        val outputFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE)
        // The string date is returned in a good format
        return outputFormat.format(date)
    }

    // This converts a date string found in the RSS XML feed to a Date object
    fun xmlDateToDate(dateString: String?): Date {
        val date = dateString ?: return Date()
        val inFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.FRANCE)
        return inFormat.parse(date) ?: Date()
    }

    // This function takes care of the date of each episode int he details screen
    fun dateToShortDate(date: Date): String {
        val outputFormat = DateFormat.getDateInstance(
            DateFormat.SHORT, Locale.FRANCE
        )
        return outputFormat.format(date)
    }

}
