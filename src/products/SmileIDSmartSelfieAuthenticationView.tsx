import {ViewProps} from "react-native";
import * as React from "react";
import {requireNativeViewManager} from "expo-modules-core";
import {SmartSelfieParams} from "../types/SmileIDExpo.types";

interface SmileIDSmartSelfieAuthenticationViewProps extends ViewProps {
    params: SmartSelfieParams;
    onResult?: (result: any) => void;
    onError?: (error: any) => void;
}

const NativeView: React.ComponentType<SmileIDSmartSelfieAuthenticationViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieAuthenticationView' );

export default function SmileIDSmartSelfieAuthenticationView(props: SmileIDSmartSelfieAuthenticationViewProps) {
    return <NativeView {...props} />;
}