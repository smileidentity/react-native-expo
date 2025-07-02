import * as React from 'react';

import { SmileIDExpoViewProps } from './SmileIDExpo.types';

export default function SmileIDExpoView(props: SmileIDExpoViewProps) {
  return (
    <div>
      <iframe
        style={{ flex: 1 }}
        src={props.url}
        onLoad={() => props.onLoad({ nativeEvent: { url: props.url } })}
      />
    </div>
  );
}
