import ExpoModulesCore
import SwiftUI
import UIKit

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
