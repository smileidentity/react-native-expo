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
 * Type‑safe bridge for the JS `SmileConfig` object coming from JavaScript.
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
 * Type‑safe bridge for the JS `DocumentVerificationParams` object
 */
class DocumentVerificationRecord : Record {
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
* Map DocumentVerificationRecord to DocumentVerificationProps
 */
internal fun DocumentVerificationRecord.toDocumentVerificationProps(): DocumentVerificationProps {
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
 * Type‑safe bridge for the JS `EnhancedDocumentVerificationParams` object
 */
class EnhancedDocumentVerificationRecord : Record {
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
    var consentInformationParams: ConsentInformationParams? = null

}

/**
 * Type‑safe bridge for the JS `ConsentInformationParams` object
 */
class ConsentInformationParams : Record {
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
internal fun EnhancedDocumentVerificationRecord.toDocumentVerificationProps(): DocumentVerificationProps {
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
        consentInformation = this.consentInformationParams.toConsentInformation()
    )
}

/**
 * Map ConsentInformationParams to ConsentInformation
 */

internal fun ConsentInformationParams?.toConsentInformation(): ConsentInformation {
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
 * Type‑safe bridge for the JS `SmartSelfieParams` object
 */
class SmartSelfieRecord: Record {
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
internal fun SmartSelfieRecord.toSmartSelfieEnrollmentProps(): SmartSelfieProps {
    return SmartSelfieProps(
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
 * Type‑safe bridge for the JS `BiometricKYCParams` object
 */
class BiometricKYCRecord: Record {
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
    var consentInformationParams: ConsentInformationParams? = null

    @Field
    var idInfo: IdInfoRecord? = null

    @Field
    var extraParams: ImmutableMap<String, String> = persistentMapOf()
}

/*
* Type‑safe bridge for the JS `IdInfoParams` object
 */

class IdInfoRecord: Record {
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

/**
 * Map BiometricKYCRecord to BiometricKYCProps
 */
internal fun BiometricKYCRecord.toBiometricKYCProps(): BiometricKYCProps {
    return BiometricKYCProps(
        userId = this.userId,
        jobId = this.jobId,
        allowNewEnroll = this.allowNewEnroll,
        allowAgentMode = this.allowAgentMode,
        showAttribution = this.showAttribution,
        showInstructions = this.showInstructions,
        skipApiSubmission = this.skipApiSubmission,
        useStrictMode = this.useStrictMode,
        consentInformation = this.consentInformationParams.toConsentInformation(),
        extraParams = this.extraParams,
        idInfo = this.idInfo.toIdInfo()
    )
}

/**
 * Map IdInfoRecord to IdInfo
*/
internal fun IdInfoRecord?.toIdInfo(): IdInfo {
    return IdInfo(
        country = this?.country ?: "",
        idNumber = this?.idNumber,
        idType = this?.idType,
        firstName = this?.firstName,
        middleName = this?.middleName,
        lastName = this?.lastName,
        dob = this?.dob,
        bankCode = this?.bankCode,
        entered = this?.entered ?: false
    )
}
