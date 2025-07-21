package com.smileidentity.react.expo

import com.smileidentity.models.Config
import com.smileidentity.models.ConsentInformation
import com.smileidentity.models.ConsentedInformation
import com.smileidentity.models.IdInfo
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
class DocumentVerificationRequest : Record {
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
internal fun DocumentVerificationRequest.toDocumentVerificationProps(): DocumentVerificationProps {
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
class EnhancedDocumentVerificationRequest : Record {
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
    var consentInformationRequest: ConsentInformationRequest? = null

}

class ConsentInformationRequest : Record {
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
internal fun EnhancedDocumentVerificationRequest.toDocumentVerificationProps(): DocumentVerificationProps {
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
        consentInformation = this.consentInformationRequest.toConsentInformation()
    )
}

/**
 * Map ConsentInformationRequest to ConsentInformation
 */

internal fun ConsentInformationRequest?.toConsentInformation(): ConsentInformation {
    return ConsentInformation(
        consented = ConsentedInformation(
            consentGrantedDate = this?.consentGrantedDate ?: getCurrentIsoTimestamp(),
            personalDetails = this?.personalDetails ?: false,
            contactInformation = this?.contactInformation ?: false,
            documentInformation = this?.documentInformation ?: false
        )
    )
}


/**
 * Type‑safe bridge for the JS `ExpoSmartSelfieEnrollmentRequest` object
 */
class SmartSelfieEnrollmentRequest: Record {
    @Field
    var userId: String? = null

    @Field
    var jobId: String? = null

    @Field
    var allowNewEnroll: Boolean = true

    @Field
    var allowAgentMode: Boolean = false

    @Field
    var showAttribution: Boolean = true

    @Field
    var showInstructions: Boolean = true

    @Field
    var skipApiSubmission: Boolean = false

    @Field
    var useStrictMode: Boolean = false

    @Field
    var extraParams: ImmutableMap<String, String> = persistentMapOf()
}

/*
* Map SmartSelfieEnrollmentRequest to SmartSelfieEnrollmentProps
 */
internal fun SmartSelfieEnrollmentRequest.toSmartSelfieEnrollmentProps(): SmartSelfieEnrollmentProps {
    return SmartSelfieEnrollmentProps(
        userId = this.userId,
        jobId = this.jobId,
        allowNewEnroll = this.allowNewEnroll,
        allowAgentMode = this.allowAgentMode,
        showAttribution = this.showAttribution,
        showInstructions = this.showInstructions,
        skipApiSubmission = this.skipApiSubmission,
        useStrictMode = this.useStrictMode,
        extraParams = this.extraParams
    )
}

/**
 * Type‑safe bridge for the JS `BiometricKYCRequest` object
 */
class BiometricKYCRequest: Record {
    @Field
    var userId: String? = null

    @Field
    var jobId: String? = null

    @Field
    var allowNewEnroll: Boolean = true

    @Field
    var allowAgentMode: Boolean = false

    @Field
    var showAttribution: Boolean = true

    @Field
    var showInstructions: Boolean = true

    @Field
    var skipApiSubmission: Boolean = false

    @Field
    var useStrictMode: Boolean = false

    @Field
    var consentInformationRequest: ConsentInformationRequest? = null

    @Field
    var idInfo: IdInfoRequest? = null

    @Field
    var extraParams: ImmutableMap<String, String> = persistentMapOf()
}

/*
* Type‑safe bridge for the JS `ExpoIdInfoRequest` object
 */

class IdInfoRequest: Record {
    @Field
    var country: String= ""
    @Field
    var idNumber: String? = null
    @Field
    var idType: String? = null
    @Field
    var firstName: String? = null
    @Field
    var middleName: String? = null
    @Field
    var lastName: String? = null
    @Field
    var dob: String? = null
    @Field
    var bankCode: String? = null
    @Field
    var entered: Boolean = false
}

internal fun BiometricKYCRequest.toBiometricKYCProps(): BiometricKYCProps {
    return BiometricKYCProps(
        userId = this.userId,
        jobId = this.jobId,
        allowNewEnroll = this.allowNewEnroll,
        allowAgentMode = this.allowAgentMode,
        showAttribution = this.showAttribution,
        showInstructions = this.showInstructions,
        skipApiSubmission = this.skipApiSubmission,
        useStrictMode = this.useStrictMode,
        consentInformation = this.consentInformationRequest.toConsentInformation(),
        extraParams = this.extraParams,
        idInfo = this.idInfo.toIdInfo()
    )
}

internal fun IdInfoRequest?.toIdInfo(): IdInfo {
    return IdInfo(
        country = this?.country ?: "",
        idNumber = this?.idNumber,
        idType = this?.idType,
        firstName = this?.firstName,
        middleName = this?.middleName,
        lastName = this?.lastName,
        dob = this?.dob,
        bankCode = this?.bankCode,
        entered = this?.entered
    )
}