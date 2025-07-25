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
    @Field public var consentInformationRequest: ConsentInformationRequest?
}

/// Type‑safe bridge for the JS `ExpoConsentInformation` object
struct ConsentInformationRequest: Record {
    @Field public var consentGrantedDate: String
    @Field public var personalDetails: Bool
    @Field public var contactInformation: Bool
    @Field public var documentInformation: Bool
}

/// Type‑safe bridge for the JS `ExpoSmartSelfieEnrollmentRequest` object
struct SmartSelfieEnrollmentRequest: Record {
    @Field public var userId: String?
    @Field public var jobId: String?
    @Field public var allowNewEnroll: Bool = true
    @Field public var allowAgentMode: Bool = false
    @Field public var showAttribution: Bool = true
    @Field public var showInstructions: Bool = true
    @Field public var skipApiSubmission: Bool = false
    @Field public var useStrictMode: Bool = false
    @Field public var extraPartnerParams: [String: String] = [:]
}

/// Type‑safe bridge for the JS `ExpoBiometricKYCRequest` object
struct BiometricKYCRequest: Record {
    @Field public var userId: String?
    @Field public var jobId: String?
    @Field public var allowNewEnroll: Bool = true
    @Field public var allowAgentMode: Bool = false
    @Field public var showAttribution: Bool = true
    @Field public var showInstructions: Bool = true
    @Field public var skipApiSubmission: Bool = false
    @Field public var useStrictMode: Bool = false
    @Field public var extraPartnerParams: [String: String] = [:]
    @Field public var consentInformationRequest: ConsentInformationRequest?
    @Field public var idInfo: IdInfoRequest
}

/// Type‑safe bridge for the JS `ExpoIdInfoRequest` object
struct IdInfoRequest: Record {
    @Field public var country: String
    @Field public var idType: String?
    @Field public var idNumber: String?
    @Field public var firstName: String?
    @Field public var middleName: String?
    @Field public var lastName: String?
    @Field public var dob: String?
    @Field public var bankCode: String?
    @Field public var entered: Bool = false
}
