package com.smileidentity.react.expo

import expo.modules.kotlin.records.Record
import expo.modules.kotlin.records.Field

/**
 * Type‑safe bridge for the JS `ExpoConfig` object coming from JavaScript.
 */
class SmileConfigRecord : Record {
    @Field
    var partnerId: String = ""

    @Field
    var authToken: String = ""

    @Field
    var prodLambdaUrl: String = ""

    @Field
    var testLambdaUrl: String = ""
}

/**
 * Type‑safe bridge for the JS `ExpoDocumentVerificationRequest` object
 */
class SmileDocumentVerificationRequestRecord : Record {
    @Field
    var userId: String = ""

    @Field
    var jobId: String = ""

    @Field
    var countryCode: String = ""

    @Field
    var allowNewEnrollment: Boolean = true

    @Field
    var documentType: String = ""

    @Field
    var idAspectRatio: Double? = null

    @Field
    var bypassSelfieCaptureWithFile: String? = null

    @Field
    var enableAutoCapture: Boolean = true

    @Field
    var captureBothSides: Boolean = true

    @Field
    var allowAgentMode: Boolean = false

    @Field
    var allowGalleryUpload: Boolean = false

    @Field
    var showInstructions: Boolean = true

    @Field
    var showAttribution: Boolean = true

    @Field
    var skipApiSubmission: Boolean = false

    @Field
    var useStrictMode: Boolean = false

    @Field
    var extraParams: Map<String, String>? = mapOf()
}