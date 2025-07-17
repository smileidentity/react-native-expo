import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import { ExpoEnhancedDocumentVerificationRequest } from "../types/SmileIDExpo.types";

interface SmileIDDocumentVerificationEnhancedViewProps extends ViewProps {
    config: ExpoEnhancedDocumentVerificationRequest;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDDocumentVerificationEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDDocumentVerificationEnhancedView');

export default function SmileIDDocumentVerificationEnhancedView(props: SmileIDDocumentVerificationEnhancedViewProps) {
    return <NativeView {...props} />;
}