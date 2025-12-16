package com.smileidentity.react.expo

import com.smileidentity.results.DocumentVerificationResult
import com.smileidentity.results.EnhancedDocumentVerificationResult
import java.io.File
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

/**
 * Converts to a [Map] for cross-platform serialization.
 * Nullable fields are omitted when null or empty.
 */
fun DocumentVerificationResult.toMap(): Map<String, Any> = buildMap {
    put("documentFrontFile", documentFrontFile.toString())
    put("selfieFile", selfieFile.toString())
    put("didSubmitDocumentVerificationJob", didSubmitDocumentVerificationJob)
    documentBackFile?.let { put("documentBackFile", it.toString()) }
}

/**
 * Converts to a [Map] for cross-platform serialization.
 * Nullable fields are omitted when null or empty.
 */
fun EnhancedDocumentVerificationResult.toMap(): Map<String, Any> = buildMap {
    put("documentFrontFile", documentFrontFile.toString())
    put("selfieFile", selfieFile.toString())
    put("didSubmitEnhancedDocVJob", didSubmitEnhancedDocVJob)
    documentBackFile?.let { put("documentBackFile", it.toString()) }
}