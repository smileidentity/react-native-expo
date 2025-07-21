import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import { ExpoBiometricKYCRequest } from "../types/SmileIDExpo.types";

interface SmileIDBiometricKYCViewProps extends ViewProps {
    config: ExpoBiometricKYCRequest;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDBiometricKYCViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDBiometricKYCView');

export default function SmileIDBiometricKYCView(props: SmileIDBiometricKYCViewProps) {
    return <NativeView {...props} />;
}