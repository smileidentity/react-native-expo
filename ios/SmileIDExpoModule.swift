import ExpoModulesCore
import SmileID
import SwiftUI
import UIKit

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
               useSandBox: Bool,
               enableCrashReporting: Bool,
               config: SmileConfigRecord?,
               apiKey: String?
           ) async throws -> Void in
           
           if let apiKey = apiKey, let config = config {
               // Case 1: Initialize with API key and config
              SmileID.initialize(
                apiKey: apiKey,
                config: Config(
                    partnerId: config.partnerId,
                    authToken: config.authToken,
                    prodLambdaUrl: config.prodLambdaUrl,
                    testLambdaUrl: config.testLambdaUrl
                ),
                useSandbox: useSandBox
               )
           } else if let config = config {
               // Case 2: Initialize with just config
               SmileID.initialize(
                   config: Config(
                       partnerId: config.partnerId,
                       authToken: config.authToken,
                       prodLambdaUrl: config.prodLambdaUrl,
                       testLambdaUrl: config.testLambdaUrl
                   ),
                   useSandbox: useSandBox
               )
           } else {
               // Case 3: Basic initialization
               SmileID.initialize(useSandbox: useSandBox)
           }
       }


        // Document Verification View
        View(SmileIDDocumentVerificationView.self) {
            Events("onResult", "onError")
            
            Prop("config") { (
                view: SmileIDDocumentVerificationView,
                config: DocumentVerificationRequest
            ) in
                view.updateConfig(config)
            }
        }

        // Enhanced Document Verification View
        View(SmileIDDocumentVerificationEnhancedView.self) {
            Events("onResult", "onError")

            Prop("config") { (
                view: SmileIDDocumentVerificationEnhancedView,
                config: EnhancedDocumentVerificationRequest
            ) in
                view.updateConfig(config)
            }
        }

        // SmartSelfie Enrollment View
        View(SmileIDSmartSelfieEnrollmentView.self) {
            Events("onResult", "onError")


            Prop("config") { (
                view: SmileIDSmartSelfieEnrollmentView,
                config: SmartSelfieEnrollmentRequest
            ) in
                view.updateConfig(config)
            }
        }
        
        // Enhanced SmartSelfie Enrollment View
        View(SmileIDSmartSelfieEnrollmentEnhancedView.self) {
            Events("onResult", "onError")

            Prop("config") { (
                view: SmileIDSmartSelfieEnrollmentEnhancedView,
                config: SmartSelfieEnrollmentRequest
            ) in
                view.updateConfig(config)
            }
        }
        
        // SmartSelfie Authentication View
        View(SmileIDSmartSelfieAuthenticationView.self) {
            Events("onResult", "onError")
            
            Prop("config") { (
                view: SmileIDSmartSelfieAuthenticationView,
                config: SmartSelfieEnrollmentRequest
            ) in
                view.updateConfig(config)
            }
        }
        
        // Enhanced SmartSelfie Authentication View
        View(SmileIDSmartSelfieAuthenticationEnhancedView.self) {
            Events("onResult", "onError")
            
            Prop("config") { (
                view: SmileIDSmartSelfieAuthenticationEnhancedView,
                config: SmartSelfieEnrollmentRequest
            ) in
                view.updateConfig(config)
            }
        }
        
        // Biometric KYC View
        View(SmileIDBiometricKYCView.self) {
            Events("onResult", "onError")
            
            Prop("config") { (
                view: SmileIDBiometricKYCView,
                config: BiometricKYCRequest
            ) in
                view.updateConfig(config)
            }
        }
        
    }
}
