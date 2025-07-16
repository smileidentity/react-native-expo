import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";

interface SmileIDEnhancedKyCViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDEnhancedKyCViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDEnhancedKyCView');

export default function SmileIDEnhancedKyCView(props: SmileIDEnhancedKyCViewProps) {
    return <NativeView {...props} />;
}