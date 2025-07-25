import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";
import { SmartSelfieParams} from "../types/SmileIDExpo.types";

interface SmileIDSmartSelfieEnrollmentViewProps extends ViewProps {
    params: SmartSelfieParams;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDSmartSelfieEnrollmentViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieEnrollmentView' );

export default function SmileIDSmartSelfieEnrollmentView(props: SmileIDSmartSelfieEnrollmentViewProps) {
    return <NativeView {...props} />;
}