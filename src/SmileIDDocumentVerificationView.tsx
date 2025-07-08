import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";

interface SmileIDDocumentVerificationViewProps extends ViewProps {
    countryCode?: string;
    userId?: string;
    jobId?: string;
    onSuccess: (event: { nativeEvent: {  } }) => void;
    onError: (event: { nativeEvent: {  } }) => void;
}

const NativeView = requireNativeViewManager('SmileIDExpo', 'SmileIDDocumentVerificationView') as React.ComponentType<SmileIDDocumentVerificationViewProps>;

export default function SmileIDDocumentVerificationView(props: SmileIDDocumentVerificationViewProps) {
    return <NativeView {...props} />;
}