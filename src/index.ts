// Reexport the native module. On web, it will be resolved to SmileIDExpoModule.web.ts
// and on native platforms to SmileIDExpoModule.ts
import SmileIDExpoModule from "./SmileIDExpoModule";

export { default } from './SmileIDExpoModule';

import SmileIDSmartSelfieEnrollmentView from './SmileIDSmartSelfieEnrollmentView';
export { SmileIDSmartSelfieEnrollmentView };

import SmileIDSmartSelfieEnrollmentEnhancedView from './SmileIDSmartSelfieEnrollmentEnhancedView';
export { SmileIDSmartSelfieEnrollmentEnhancedView };

import SmileIDDocumentVerificationView from './SmileIDDocumentVerificationView';
export { SmileIDDocumentVerificationView };

import SmileIDDocumentVerificationEnhancedView from './SmileIDDocumentVerificationEnhancedView';
export { SmileIDDocumentVerificationEnhancedView };

import SmileIDBvnConsentScreenView from './SmileIDBvnConsentScreenView';
export { SmileIDBvnConsentScreenView };

import SmileIDSmartSelfieAuthenticationView from "./SmileIDSmartSelfieAuthenticationView";
export { SmileIDSmartSelfieAuthenticationView };

import SmileIDSmartSelfieAuthenticationEnhancedView from "./SmileIDSmartSelfieAuthenticationEnhancedView";
export { SmileIDSmartSelfieAuthenticationEnhancedView };

import SmileIDBiometricKYCView from "./SmileIDBiometricKYCView";
export { SmileIDBiometricKYCView };

import SmileIDEnhancedKyCView  from "./SmileIDEnhancedKyCView";
export { SmileIDEnhancedKyCView };




export * from  './SmileIDExpo.types';
import type { ExpoConfig } from './SmileIDExpo.types';

export function initialize(
    useSandBox: boolean,
    enableCrashReporting: boolean,
    config?: ExpoConfig,
    apiKey?: string
): Promise<void> {
    return SmileIDExpoModule.initialize(useSandBox, enableCrashReporting, config, apiKey);
}