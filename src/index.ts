// Reexport the native module. On web, it will be resolved to SmileIDExpoModule.web.ts
// and on native platforms to SmileIDExpoModule.ts
import SmileIDExpoModule from "./SmileIDExpoModule";

export { default } from './SmileIDExpoModule';

import SmileIDSmartSelfieEnrollmentView from './products/SmileIDSmartSelfieEnrollmentView';
export { SmileIDSmartSelfieEnrollmentView };

import SmileIDSmartSelfieEnrollmentEnhancedView from './products/SmileIDSmartSelfieEnrollmentEnhancedView';
export { SmileIDSmartSelfieEnrollmentEnhancedView };

import SmileIDDocumentVerificationView from './products/SmileIDDocumentVerificationView';
export { SmileIDDocumentVerificationView };

import SmileIDDocumentVerificationEnhancedView from './products/SmileIDDocumentVerificationEnhancedView';
export { SmileIDDocumentVerificationEnhancedView };

import SmileIDBvnConsentScreenView from './products/SmileIDBvnConsentScreenView';
export { SmileIDBvnConsentScreenView };

import SmileIDSmartSelfieAuthenticationView from "./products/SmileIDSmartSelfieAuthenticationView";
export { SmileIDSmartSelfieAuthenticationView };

import SmileIDSmartSelfieAuthenticationEnhancedView from "./products/SmileIDSmartSelfieAuthenticationEnhancedView";
export { SmileIDSmartSelfieAuthenticationEnhancedView };

import SmileIDBiometricKYCView from "./products/SmileIDBiometricKYCView";
export { SmileIDBiometricKYCView };

import SmileIDEnhancedKyCView  from "./products/SmileIDEnhancedKyCView";
export { SmileIDEnhancedKyCView };

export * from './types/SmileIDExpo.types';
import type { ExpoConfig } from './types/SmileIDExpo.types';

export function initialize(
    useSandBox: boolean,
    enableCrashReporting: boolean,
    config?: ExpoConfig,
    apiKey?: string
): Promise<void> {
    return SmileIDExpoModule.initialize(useSandBox, enableCrashReporting, config, apiKey);
}