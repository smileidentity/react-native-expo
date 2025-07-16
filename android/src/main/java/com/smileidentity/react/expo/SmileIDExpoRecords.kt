package com.smileidentity.react.expo

import com.smileidentity.models.Config
import com.smileidentity.models.ConsentInformation
import com.smileidentity.models.ConsentedInformation
import expo.modules.kotlin.records.Record
import expo.modules.kotlin.records.Field
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentMapOf
import java.io.File

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
    var userId: String? = null

    @Field
    var jobId: String? = null

    @Field
    var countryCode: String = ""

    @Field
    var allowNewEnroll: Boolean = false

    @Field
    var documentType: String? = null

    @Field
    var idAspectRatio: Float? = null

    @Field
    var bypassSelfieCaptureWithFile: File? = null

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
    var extraParams: ImmutableMap<String, String> = persistentMapOf()
}

/*
* Map the record to the SDK's expected Config data class
* */
internal fun SmileConfigRecord.toConfig(): Config {
    return Config(
        partnerId = this.partnerId,
        authToken = this.authToken,
        prodLambdaUrl = this.prodLambdaUrl,
        testLambdaUrl = this.testLambdaUrl
    )
}

/*
* Map DocumentVerificationProps to SmileDocumentVerificationRequestRecord
 */
internal fun SmileDocumentVerificationRequestRecord.toDocumentVerificationProps(): DocumentVerificationProps {
    return DocumentVerificationProps(
        userId = this.userId,
        jobId = this.jobId,
        countryCode = this.countryCode,
        allowNewEnroll = this.allowNewEnroll,
        documentType = this.documentType,
        idAspectRatio = this.idAspectRatio,
        bypassSelfieCaptureWithFile = this.bypassSelfieCaptureWithFile,
        enableAutoCapture = this.enableAutoCapture,
        captureBothSides = this.captureBothSides,
        allowAgentMode = this.allowAgentMode,
        allowGalleryUpload = this.allowGalleryUpload,
        showInstructions = this.showInstructions,
        showAttribution = this.showAttribution,
        skipApiSubmission = this.skipApiSubmission,
        useStrictMode = this.useStrictMode,
        extraParams = this.extraParams
    )
}

/**
 * Type‑safe bridge for the JS `ExpoDocumentVerificationRequest` object
 */
class SmileEnhancedDocumentVerificationRequestRecord : Record {
    @Field
    var userId: String? = null

    @Field
    var jobId: String? = null

    @Field
    var countryCode: String = ""

    @Field
    var allowNewEnroll: Boolean = false

    @Field
    var documentType: String? = null

    @Field
    var idAspectRatio: Float? = null

    @Field
    var bypassSelfieCaptureWithFile: File? = null

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
    var extraParams: ImmutableMap<String, String> = persistentMapOf()

    @Field
    var consentInformationRecord: SmileConsentInformationRecord? = null

}

class SmileConsentInformationRecord : Record {
    @Field
    var consentGrantedDate: String? = null
    @Field
    var personalDetails: Boolean = false
    @Field
    var contactInformation: Boolean = false
    @Field
    var documentInformation: Boolean = false
}

/**
 * Map EnhancedDocumentVerificationRequestRecord to DocumentVerificationProps
 */
internal fun SmileEnhancedDocumentVerificationRequestRecord.toDocumentVerificationProps(): DocumentVerificationProps {
    return DocumentVerificationProps(
        userId = this.userId,
        jobId = this.jobId,
        countryCode = this.countryCode,
        allowNewEnroll = this.allowNewEnroll,
        documentType = this.documentType,
        idAspectRatio = this.idAspectRatio,
        bypassSelfieCaptureWithFile = this.bypassSelfieCaptureWithFile,
        enableAutoCapture = this.enableAutoCapture,
        captureBothSides = this.captureBothSides,
        allowAgentMode = this.allowAgentMode,
        allowGalleryUpload = this.allowGalleryUpload,
        showInstructions = this.showInstructions,
        showAttribution = this.showAttribution,
        skipApiSubmission = this.skipApiSubmission,
        useStrictMode = this.useStrictMode,
        extraParams = this.extraParams,
        consentInformation = this.consentInformationRecord?.toConsentInformation()
    )
}

/**
 * Map SmileConsentInformationRecord to ConsentInformation
 */

internal fun SmileConsentInformationRecord.toConsentInformation(): ConsentInformation {
    return ConsentInformation(
        consented = ConsentedInformation(
            consentGrantedDate = this.consentGrantedDate ?: getCurrentIsoTimestamp(),
            personalDetails = this.personalDetails,
            contactInformation = this.contactInformation,
            documentInformation = this.documentInformation
        )
    )
}
