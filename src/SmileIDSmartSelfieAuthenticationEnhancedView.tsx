import {ViewProps} from "react-native";
import * as React from "react";
import {requireNativeViewManager} from "expo-modules-core";

interface SmileIDSmartSelfieAuthenticationEnhancedViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDSmartSelfieAuthenticationEnhancedViewProps> =
    requireNativeViewManager('SmileIDExpo','SmileIDSmartSelfieAuthenticationEnhancedView' );

export default function SmileIDSmartSelfieAuthenticationEnhancedView(props: SmileIDSmartSelfieAuthenticationEnhancedViewProps) {
    return <NativeView {...props} />;
}