import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";

interface SmileIDDocumentVerificationEnhancedViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDDocumentVerificationEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDDocumentVerificationEnhancedView');

export default function SmileIDDocumentVerificationEnhancedView(props: SmileIDDocumentVerificationEnhancedViewProps) {
    return <NativeView {...props} />;
}