import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";


interface SmileIDDocumentVerificationViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDDocumentVerificationViewProps> =
    requireNativeViewManager('SmileIDExpo');

export default function SmileIDDocumentVerificationView(props: SmileIDDocumentVerificationViewProps) {
    return <NativeView {...props} />;
}