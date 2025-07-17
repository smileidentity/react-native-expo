import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import {ExpoSmartSelfieEnrollmentRequest} from "../types/SmileIDExpo.types";


interface SmileIDSmartSelfieEnrollmentEnhancedViewProps extends ViewProps {
    config: ExpoSmartSelfieEnrollmentRequest;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDSmartSelfieEnrollmentEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieEnrollmentEnhancedView' );

export default function SmileIDSmartSelfieEnrollmentEnhancedView(props: SmileIDSmartSelfieEnrollmentEnhancedViewProps) {
    return <NativeView {...props} />;
}