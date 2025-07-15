import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";

interface SmileIDBiometricKYCViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDBiometricKYCViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDBiometricKYCView');

export default function SmileIDBiometricKYCView(props: SmileIDBiometricKYCViewProps) {
    return <NativeView {...props} />;
}