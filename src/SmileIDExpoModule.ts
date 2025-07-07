import { NativeModule, requireNativeModule } from 'expo';

import { SmileIDExpoModuleEvents, ExpoConfig } from './SmileIDExpo.types';

declare class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  /**
   * Initialize SmileID SDK with configuration
   * @param config - Configuration object for the SDK
   * @param useSandBox - Configuration object for the SDK
   * @param apiKey - api key specific to the partner and also environment
   * @param enableCrashReporting - Whether to enable crash reporting
   */
  initialize(
      config: ExpoConfig,
      useSandBox: boolean,
      enableCrashReporting: boolean,
      apiKey?: string
  ): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>('SmileIDExpo');
