import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";


interface SmileIDSmartSelfieEnrollmentEnhancedViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDSmartSelfieEnrollmentEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieEnrollmentEnhancedView' );

export default function SmileIDSmartSelfieEnrollmentEnhancedView(props: SmileIDSmartSelfieEnrollmentEnhancedViewProps) {
    return <NativeView {...props} />;
}