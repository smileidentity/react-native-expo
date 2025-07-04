import { NativeModule, requireNativeModule } from 'expo';

import { SmileIDExpoModuleEvents } from './SmileIDExpo.types';

declare class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  /**
   * Initialize SmileID SDK with configuration
   * @param useSandBox - Configuration object for the SDK
   * @param apiKey - api key specific to the partner and also environment
   * @param config - Configuration object for the SDK
   * @param enableCrashReporting - Whether to enable crash reporting
   */
  initialize(
      useSandBox: boolean,
      enableCrashReporting: boolean,
      apiKey?: string
  ): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>('SmileIDExpo');
