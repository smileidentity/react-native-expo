import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import {SmartSelfieParams} from "../types/SmileIDExpo.types";

interface SmileIDSmartSelfieEnrollmentEnhancedViewProps extends ViewProps {
    params: SmartSelfieParams;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDSmartSelfieEnrollmentEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieEnrollmentEnhancedView' );

export default function SmileIDSmartSelfieEnrollmentEnhancedView(props: SmileIDSmartSelfieEnrollmentEnhancedViewProps) {
    return <NativeView {...props} />;
}