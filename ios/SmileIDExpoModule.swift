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
        AsyncFunction("initalize") {
            (
                useSandBox: Bool,
                enableCrashReporting: Bool,
                apiKey: String?
            ) -> Void in
            SmileID.initialize(
                apiKey: apiKey,
                useSandbox: useSandBox
            )
        }

        // Function to present Document Verification view
        AsyncFunction("presentDocumentVerification") { () -> Void in
            DispatchQueue.main.async {
                let documentVerificationView = SmileIDDocumentVerificationView()
                self.presentView(documentVerificationView)
            }
        }

        // Function to present SmartSelfie Enrollment view
        AsyncFunction("presentSmartSelfieEnrollment") { () -> Void in
            DispatchQueue.main.async {
                let smartSelfieView = SmileIDSmartSelfieEnrollmentView()
                self.presentView(smartSelfieView)
            }
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

// MARK: - Helper Methods
extension SmileIDExpoModule {
    /// Presents a view modally using a full screen presentation style
    private func presentView<T: UIView>(_ view: T) {
        guard
            let windowScene = UIApplication.shared.connectedScenes
                .compactMap({ $0 as? UIWindowScene })
                .first(where: { $0.activationState == .foregroundActive }),
            let rootViewController = windowScene.windows.first(where: { $0.isKeyWindow })?.rootViewController
        else {
            return
        }

        let viewController = UIViewController()
        viewController.modalPresentationStyle = .fullScreen
        viewController.view.backgroundColor = .systemBackground
        viewController.view.addSubview(view)
        view.fillSuperview()

        rootViewController.present(viewController, animated: true)
    }
}
