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
export interface ExpoDocumentVerificationRequest {
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
export interface ExpoEnhancedDocumentVerificationRequest {
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

export interface ExpoConsentInformation {
  consentGrantedDate: string;
  personalDetails: boolean;
  contactInformation: boolean;
  documentInformation: boolean
}
