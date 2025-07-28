import { NativeModule, requireNativeModule } from "expo";

import {
  SmileConfig,
  SmileIDExpoModuleEvents,
} from "./types/SmileIDExpo.types";

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
      config?: SmileConfig,
      apiKey?: string,
  ): Promise<void>;

  /**
   * The callback mechanism allows for asynchronous job requests and responses.
   * While the job_status API can be polled to get a result, a better method is to set up a
   * callback url and let the system POST a JSON response.
   */
  setCallbackUrl: (callbackUrl: string) => Promise<void>;

  /**
   * Sets allow offline mode which enables
   * the ability to capture jobs offline and submit later
   */
  setAllowOfflineMode: (allowOfflineMode: boolean) => Promise<void>;

  /**
   * Submits an already captured job id
   */
  submitJob: (jobId: string) => Promise<void>;

  /**
   * Returns all job ids from the submitted directory
   */
  getSubmittedJobs: () => Promise<[string]>;

  /**
   * Returns all job ids from the unsubmitted directory
   */
  getUnsubmittedJobs: () => Promise<[string]>;

  /**
   * Cleans up a job id from the submitted or unsubmitted
   * directory
   */
  cleanup: (jobId: string) => Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>("SmileIDExpo");
