import ExpoModulesCore
import SwiftUI
import SmileID

// Enhanced SmartSelfie Enrollment View using ExpoView
final class SmileIDSmartSelfieEnrollmentEnhancedView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: SmartSelfieEnrollmentDelegate
    private let hostingController: UIHostingController<EnhancedSmartSelfieEnrollmentView>
		private let navigationController: UINavigationController
    private var config: SmartSelfieParams?

    required init(appContext: AppContext? = nil) {
        delegate = SmartSelfieEnrollmentDelegate()
        hostingController = UIHostingController(
            rootView: EnhancedSmartSelfieEnrollmentView(
                delegate: delegate,
                config: nil
            )
        )
				navigationController = UINavigationController(rootViewController: hostingController)
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
        hostingController.rootView = EnhancedSmartSelfieEnrollmentView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID Enhanced SmartSelfie enrollment screen
struct EnhancedSmartSelfieEnrollmentView: View {
    let delegate: SmartSelfieEnrollmentDelegate
    let config: SmartSelfieParams?

    var body: some View {
        if let config = config {
            SmileID.smartSelfieEnrollmentScreenEnhanced(
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

