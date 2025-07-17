package com.smileidentity.react.expo

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 *  Utility function to get the current ISO timestamp in UTC format.
 */
fun getCurrentIsoTimestamp(): String {
    val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    val sdf = SimpleDateFormat(pattern, Locale.US)
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    return sdf.format(Date())
}