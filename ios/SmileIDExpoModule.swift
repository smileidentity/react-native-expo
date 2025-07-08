import ExpoModulesCore
import SmileID
import SwiftUI
import UIKit

/// Type‑safe bridge for the JS `ExpoConfig` object
struct ExpoConfigRecord: Record {
    @Field var partnerId: String
    @Field var authToken: String
    @Field var prodLambdaUrl: String
    @Field var testLambdaUrl: String
}

public class SmileIDExpoModule: Module {

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
                config: ExpoConfigRecord,
                useSandBox: Bool,
                enableCrashReporting: Bool,
                apiKey: String?
            ) -> Void in
            SmileID.initialize(
                apiKey: apiKey,
                useSandbox: useSandBox,
                config: SmileIDConfig(
                    partnerId: config.partnerId,
                    authToken: config.authToken,
                    prodLambdaUrl: config.prodLambdaUrl,
                    testLambdaUrl: config.testLambdaUrl
                ),
                enableCrashReporting: enableCrashReporting
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
