import {ViewProps} from "react-native";
import * as React from "react";
import {requireNativeViewManager} from "expo-modules-core";
import {ExpoSmartSelfieEnrollmentRequest} from "../types/SmileIDExpo.types";

interface SmileIDSmartSelfieAuthenticationEnhancedViewProps extends ViewProps {
    config: ExpoSmartSelfieEnrollmentRequest;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDSmartSelfieAuthenticationEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieAuthenticationEnhancedView' );

export default function SmileIDSmartSelfieAuthenticationEnhancedView(props: SmileIDSmartSelfieAuthenticationEnhancedViewProps) {
    return <NativeView {...props} />;
}