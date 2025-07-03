import { NativeModule, requireNativeModule } from 'expo';

import { SmileIDExpoModuleEvents, Config } from './SmileIDExpo.types';

declare class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  initalize(
    useSandBox: boolean,
    enableCrashReporting: boolean,
    config?: Config,
    apiKey?: string
  ): Promise<void>
  
  presentDocumentVerification(): Promise<void>
  presentSmartSelfieEnrollment(): Promise<void>
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>('SmileIDExpo');
