import { requireNativeView } from 'expo';
import * as React from 'react';

import { SmileIDExpoViewProps } from './SmileIDExpo.types';

const NativeView: React.ComponentType<SmileIDExpoViewProps> =
  requireNativeView('SmileIDExpo');

export default function SmileIDExpoView(props: SmileIDExpoViewProps) {
  return <NativeView {...props} />;
}
