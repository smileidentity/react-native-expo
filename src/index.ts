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

import SmileIDSmartSelfieAuthenticationView from "./products/SmileIDSmartSelfieAuthenticationView";
export { SmileIDSmartSelfieAuthenticationView };

import SmileIDSmartSelfieAuthenticationEnhancedView from "./products/SmileIDSmartSelfieAuthenticationEnhancedView";
export { SmileIDSmartSelfieAuthenticationEnhancedView };

import SmileIDBiometricKYCView from "./products/SmileIDBiometricKYCView";
export { SmileIDBiometricKYCView };


export * from './types/SmileIDExpo.types';
import type { SmileConfig } from './types/SmileIDExpo.types';

export function initialize(
    useSandBox: boolean,
    enableCrashReporting: boolean,
    config?: SmileConfig,
    apiKey?: string
): Promise<void> {
    return SmileIDExpoModule.initialize(useSandBox, enableCrashReporting, config, apiKey);
}

export function setCallbackUrl(callbackUrl: string): Promise<void> {
    return SmileIDExpoModule.setCallbackUrl(callbackUrl);
}

export function setAllowOfflineMode(allowOfflineMode: boolean): Promise<void> {
    return SmileIDExpoModule.setAllowOfflineMode(allowOfflineMode);
}

export function submitJob(jobId: string): Promise<void> {
    return SmileIDExpoModule.submitJob(jobId);
}

export function getSubmittedJobs(): Promise<[string]> {
    return SmileIDExpoModule.getSubmittedJobs();
}

export function getUnsubmittedJobs(): Promise<[string]> {
    return SmileIDExpoModule.getUnsubmittedJobs();
}

export function cleanup(jobId: string): Promise<void> {
    return SmileIDExpoModule.cleanup(jobId);
}