// Reexport the native module. On web, it will be resolved to SmileIDExpoModule.web.ts
// and on native platforms to SmileIDExpoModule.ts
export { default } from './SmileIDExpoModule';
import SmileIDSmartSelfieEnrollmentView from './SmileIDSmartSelfieEnrollmentView';
export { SmileIDSmartSelfieEnrollmentView };

import SmileIDDocumentVerificationView from './SmileIDDocumentVerificationView';
export { SmileIDDocumentVerificationView };

export * from  './SmileIDExpo.types';
