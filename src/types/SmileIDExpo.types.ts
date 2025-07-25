/**
 * Config class used to pass the smile config to initialize method
 */
export class ExpoConfig {
  partnerId: string;
  authToken: string;
  prodLambdaUrl: string;
  testLambdaUrl: string;

  constructor(
    partnerId: string,
    authToken: string,
    prodLambdaUrl: string,
    testLambdaUrl: string
  ) {
    this.partnerId = partnerId;
    this.authToken = authToken;
    this.prodLambdaUrl = prodLambdaUrl;
    this.testLambdaUrl = testLambdaUrl;
  }
}

export type SmileIDExpoModuleEvents = {
  onChange: (params: ChangeEventPayload) => void;
};

export type ChangeEventPayload = {
  value: string;
};

/**
 * Interface for document verification request parameters
 */
export type ExpoDocumentVerificationRequest = {
  userId?: string;
  jobId?: string;
  countryCode: string;
  allowNewEnroll?: boolean;
  documentType?: string;
  idAspectRatio?: number;
  bypassSelfieCaptureWithFile?: string;
  enableAutoCapture?: boolean;
  captureBothSides?: boolean;
  allowAgentMode?: boolean;
  allowGalleryUpload?: boolean;
  showInstructions?: boolean;
  showAttribution?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
}

/**
 * Interface for document verification request parameters
 */
export type ExpoEnhancedDocumentVerificationRequest = {
  userId?: string;
  jobId?: string;
  countryCode: string;
  allowNewEnroll?: boolean;
  documentType?: string;
  idAspectRatio?: number;
  bypassSelfieCaptureWithFile?: string;
  enableAutoCapture?: boolean;
  captureBothSides?: boolean;
  allowAgentMode?: boolean;
  allowGalleryUpload?: boolean;
  showInstructions?: boolean;
  showAttribution?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
  consentInformation?: ExpoConsentInformation
}

/**
 * Interface for Consent Information request parameters
 */
export type ExpoConsentInformation = {
  consentGrantedDate: string;
  personalDetails: boolean;
  contactInformation: boolean;
  documentInformation: boolean
}

/**
 * Interface for Smart Selfie Enrolment request parameters
 */
export type ExpoSmartSelfieEnrollmentRequest = {
  userId?: string;
  jobId?: string;
  allowNewEnroll?: boolean;
  allowAgentMode?: boolean;
  showAttribution?: boolean;
  showInstructions?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
}

/**
 * Interface for Biometric KYC request parameters
 */
export type ExpoBiometricKYCRequest = {
  userId?: string;
  jobId?: string;
  allowNewEnroll?: boolean;
  allowAgentMode?: boolean;
  showAttribution?: boolean;
  showInstructions?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
  consentInformation?: ExpoConsentInformation;
  idInfo: ExpoIdInfoRequest;
}

/**
 * Interface for ID Info request parameters
 */
export type ExpoIdInfoRequest = {
  country: string;
  idType?: string;
  idNumber?: string;
  firstName?: string;
  middleName?: string;
  lastName?: string;
  dob?: string;
  bankCode?: string;
  entered?: boolean
}

/**
 * Interface for BVN Consent request parameters
 */
export type ExpoConsentRequest = {
  partnerIconId: string;
  partnerName: string;
  partnerPrivacyPolicy: string;
  productName: string,
  userId?: string
}
