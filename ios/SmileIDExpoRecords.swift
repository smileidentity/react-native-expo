import ExpoModulesCore

/// Type‑safe bridge for the JS `ExpoConfig` object
struct SmileConfigRecord: Record {
    @Field public var partnerId: String
    @Field public var authToken: String
    @Field public var prodLambdaUrl: String
    @Field public var testLambdaUrl: String
}

/// Type‑safe bridge for the JS `ExpoDocumentVerificationRequest` object
struct DocumentVerificationRequest: Record {
    @Field public var userId: String?
    @Field public var jobId: String?
    @Field public var countryCode: String
    @Field public var allowNewEnroll: Bool = true
    @Field public var documentType: String?
    @Field public var idAspectRatio: Double?
    @Field public var bypassSelfieCaptureWithFile: String?
    @Field public var enableAutoCapture: Bool = true
    @Field public var captureBothSides: Bool = true
    @Field public var allowAgentMode: Bool = false
    @Field public var allowGalleryUpload: Bool = false
    @Field public var showInstructions: Bool = true
    @Field public var showAttribution: Bool = true
    @Field public var skipApiSubmission: Bool = false
    @Field public var useStrictMode: Bool = false
    @Field public var extraPartnerParams: [String: String] = [:]
}

/// Type‑safe bridge for the JS `ExpoEnhancedDocumentVerificationRequest` object
struct EnhancedDocumentVerificationRequest: Record {
    @Field public var userId: String?
    @Field public var jobId: String?
    @Field public var countryCode: String
    @Field public var allowNewEnroll: Bool = true
    @Field public var documentType: String?
    @Field public var idAspectRatio: Double?
    @Field public var bypassSelfieCaptureWithFile: String?
    @Field public var enableAutoCapture: Bool = true
    @Field public var captureBothSides: Bool = true
    @Field public var allowAgentMode: Bool = false
    @Field public var allowGalleryUpload: Bool = false
    @Field public var showInstructions: Bool = true
    @Field public var showAttribution: Bool = true
    @Field public var skipApiSubmission: Bool = false
    @Field public var useStrictMode: Bool = false
    @Field public var extraPartnerParams: [String: String] = [:]
    @Field public var consentInformation: ExpoConsentInformation?
}

/// Type‑safe bridge for the JS `ExpoConsentInformation` object
struct ExpoConsentInformation: Record {
    @Field public var consentGrantedDate: String
    @Field public var personalDetails: Bool
    @Field public var contactInformation: Bool
    @Field public var documentInformation: Bool
}
