// Reexport the native module. On web, it will be resolved to SmileIDExpoModule.web.ts
// and on native platforms to SmileIDExpoModule.ts
import SmileIDExpoModule from "./SmileIDExpoModule";

export { default } from './SmileIDExpoModule';
import SmileIDSmartSelfieEnrollmentView from './SmileIDSmartSelfieEnrollmentView';
export { SmileIDSmartSelfieEnrollmentView };

import SmileIDDocumentVerificationView from './SmileIDDocumentVerificationView';
export { SmileIDDocumentVerificationView };

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