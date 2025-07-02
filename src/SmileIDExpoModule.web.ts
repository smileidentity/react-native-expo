import { registerWebModule, NativeModule } from 'expo';

import { SmileIDExpoModuleEvents } from './SmileIDExpo.types';

class SmileIDExpoModule extends NativeModule<SmileIDExpoModuleEvents> {
  PI = Math.PI;
  async setValueAsync(value: string): Promise<void> {
    this.emit('onChange', { value });
  }
  hello() {
    return 'Hello world! 👋';
  }
}

export default registerWebModule(SmileIDExpoModule, 'SmileIDExpoModule');
