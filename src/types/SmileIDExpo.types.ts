/**
 * Config class used to pass the smile config to initialize method
 */
export class SmileConfig {
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
 * Document verification request parameters
 */
export type DocumentVerificationParams = {
  userId?: string;
  jobId?: string;
  countryCode: string;
  allowNewEnroll?: boolean;
  documentType?: string;
  idAspectRatio?: number;
  bypassSelfieCaptureWithFile?: string;
  autoCaptureTimeout: number;
  autoCapture: AutoCapture.AutoCapture;
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
 * Enhanced Document verification request parameters
 */
export type EnhancedDocumentVerificationParams = {
  userId?: string;
  jobId?: string;
  countryCode: string;
  allowNewEnroll?: boolean;
  documentType?: string;
  idAspectRatio?: number;
  bypassSelfieCaptureWithFile?: string;
  autoCaptureTimeout: number;
  autoCapture: AutoCapture.AutoCapture;
  captureBothSides?: boolean;
  allowAgentMode?: boolean;
  allowGalleryUpload?: boolean;
  showInstructions?: boolean;
  showAttribution?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
  consentInformation?: ConsentInformationParams
}

/**
 * Consent Information request parameters
 */
export type ConsentInformationParams = {
  consentGrantedDate: string;
  personalDetails: boolean;
  contactInformation: boolean;
  documentInformation: boolean
}

/**
 * Smart Selfie request parameters
 * Used for SmartSelfie Authentication and SmartSelfie Enrolment & the enhanced versions
 */
export type SmartSelfieParams = {
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
 *  Biometric KYC request parameters
 */
export type BiometricKYCParams = {
  userId?: string;
  jobId?: string;
  allowNewEnroll?: boolean;
  allowAgentMode?: boolean;
  showAttribution?: boolean;
  showInstructions?: boolean;
  skipApiSubmission?: boolean;
  useStrictMode?: boolean;
  extraPartnerParams?: Record<string, string>;
  consentInformation?: ConsentInformationParams;
  idInfo: IdInfoParams;
}

/**
 * ID Info request parameters
 */
export type IdInfoParams = {
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
 * BVN Consent request parameters
 */
export type ConsentParams = {
  partnerIconId: string;
  partnerName: string;
  partnerPrivacyPolicy: string;
  productName: string,
  userId?: string
}


/**
 * AutoCapture request parameters
 */
export enum AutoCapture {
  AutoCapture,
  AutoCaptureOnly,
  ManualCaptureOnly
}