import {ViewProps} from "react-native";
import * as React from "react";
import {requireNativeViewManager} from "expo-modules-core";

interface SmileIDSmartSelfieAuthenticationViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDSmartSelfieAuthenticationViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieAuthenticationView' );

export default function SmileIDSmartSelfieAuthenticationView(props: SmileIDSmartSelfieAuthenticationViewProps) {
    return <NativeView {...props} />;
}