import ExpoModulesCore
import SwiftUI
import SmileID

// Enhanced SmartSelfie Authentication View using ExpoView
final class SmileIDSmartSelfieAuthenticationEnhancedView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: SmartSelfieDelegate
    private let hostingController: UIHostingController<EnhancedSmartSelfieAuthenticationView>
    private let navigationController: UINavigationController
    private var config: SmartSelfieParams?

    required init(appContext: AppContext? = nil) {
        delegate = SmartSelfieDelegate()
        hostingController = UIHostingController(
            rootView: EnhancedSmartSelfieAuthenticationView(
                delegate: delegate,
                config: nil
            )
        )
        navigationController = UINavigationController(rootViewController: hostingController)
        // Force light mode
        hostingController.overrideUserInterfaceStyle = .light

        super.init(appContext: appContext)

        // Set up delegate callbacks
        delegate.onResult = { [weak self] result in
            self?.onResult(result)
        }

        delegate.onError = { [weak self] error in
            self?.onError(["error": error.localizedDescription])
        }

        // Add the navigation controller's view
        addSubview(navigationController.view)
        navigationController.view.fillSuperview()
    }

    func updateConfig(_ config: SmartSelfieParams) {
        self.config = config
        hostingController.rootView = EnhancedSmartSelfieAuthenticationView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID Enhanced SmartSelfie authentication view
struct EnhancedSmartSelfieAuthenticationView: View {
    let delegate: SmartSelfieDelegate
    let config: SmartSelfieParams?

    var body: some View {
        if let config = config {
            SmileID.smartSelfieAuthenticationScreenEnhanced(
                userId: config.userId ?? generateUserId(),
                allowNewEnroll: config.allowNewEnroll,
                showAttribution: config.showAttribution,
                showInstructions: config.showInstructions,
                skipApiSubmission: config.skipApiSubmission,
                extraPartnerParams: config.extraPartnerParams,
                delegate: delegate
            )
        } else {
            Text("Configuration not provided").foregroundColor(.red)
        }
    }
}
