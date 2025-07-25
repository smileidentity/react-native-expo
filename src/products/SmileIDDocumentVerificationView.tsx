import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import { DocumentVerificationParams } from '../types/SmileIDExpo.types';

interface SmileIDDocumentVerificationViewProps extends ViewProps {
    params: DocumentVerificationParams;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDDocumentVerificationViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDDocumentVerificationView');

export default function SmileIDDocumentVerificationView(props: SmileIDDocumentVerificationViewProps) {
    return <NativeView {...props} />;
}