import ExpoModulesCore
import SmileID
import SwiftUI
import UIKit

// Native ExpoConfig struct to match TypeScript ExpoConfig
struct ExpoConfig: Record {
    @Field var partnerId: String
    @Field var authToken: String
    @Field var prodLambdaUrl: String
    @Field var testLambdaUrl: String
}

public class SmileIDExpoModule: Module {
    
    // Helper function to convert ExpoConfig to SmileID.Config
    private func convertToSmileIDConfig(_ expoConfig: ExpoConfig) -> Config {
        return Config(
            partnerId: expoConfig.partnerId,
            authToken: expoConfig.authToken,
            prodLambdaUrl: expoConfig.prodLambdaUrl,
            testLambdaUrl: expoConfig.testLambdaUrl
        )
    }

    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    public func definition() -> ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        // Defines a JavaScript function that always returns a Promise and whose native code
        // is by default dispatched on the different thread than the JavaScript runtime runs on.
        AsyncFunction("initialize") {
            (
                config: ExpoConfig,
                useSandBox: Bool,
                enableCrashReporting: Bool,
                apiKey: String?
            ) -> Void in
            
            // Convert ExpoConfig to SmileID.Config
            let smileConfig = self.convertToSmileIDConfig(config)
            
            SmileID.initialize(
                config: smileConfig,
                useSandbox: useSandBox
            )
        }

        // Document Verification View
        View(SmileIDDocumentVerificationView.self) {
            Events("onResult", "onError")
        }

        // SmartSelfie Enrollment View
        View(SmileIDSmartSelfieEnrollmentView.self) {
            Events("onResult", "onError")
        }
    }
}
