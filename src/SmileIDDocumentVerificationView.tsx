import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import { ExpoDocumentVerificationRequest } from './SmileIDExpo.types';

interface SmileIDDocumentVerificationViewProps extends ViewProps {
  config: ExpoDocumentVerificationRequest;
}

const NativeView: React.ComponentType<SmileIDDocumentVerificationViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDDocumentVerificationView');

export default function SmileIDDocumentVerificationView(props: SmileIDDocumentVerificationViewProps) {
    return <NativeView {...props} />;
}