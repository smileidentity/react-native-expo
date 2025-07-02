import { NativeModule, requireNativeModule } from 'expo';

import { SmileIDExpoModuleEvents } from './SmileIDExpo.types';

declare class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<SmileIDExpoModule>('SmileIDExpo');
