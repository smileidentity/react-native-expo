import { NativeModule, requireNativeModule } from 'expo';

import {ExpoConfig, SmileIDExpoModuleEvents} from './types/SmileIDExpo.types';

declare class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  /**
   * Initialize SmileID SDK with configuration
   * @param useSandBox - Configuration object for the SDK
   * @param enableCrashReporting - Whether to enable crash reporting
   * @param config - Configuration object for the SDK
   * @param apiKey - api key specific to the partner and also environment
   */
  initialize(
      useSandBox: boolean,
      enableCrashReporting: boolean,
      config?: ExpoConfig,
      apiKey?: string,
  ): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>('SmileIDExpo');
