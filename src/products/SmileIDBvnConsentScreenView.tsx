import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from "react-native";

interface SmileIDBvnConsentScreenViewProps extends ViewProps {}

const NativeView: React.ComponentType<SmileIDBvnConsentScreenViewProps> =
    requireNativeViewManager('SmileIDExpo', 'SmileIDBvnConsentScreenView');

export default function SmileIDBvnConsentScreenView(props: SmileIDBvnConsentScreenViewProps) {
    return <NativeView {...props} />;
}