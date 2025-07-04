// SmileIDSmartSelfieEnrollmentView
import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";


interface SmileIDSmartSelfieEnrollmentViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDSmartSelfieEnrollmentViewProps> =
    requireNativeViewManager('SmileIDExpo');

export default function SmileIDSmartSelfieEnrollmentView(props: SmileIDSmartSelfieEnrollmentViewProps) {
    return <NativeView {...props} />;
}