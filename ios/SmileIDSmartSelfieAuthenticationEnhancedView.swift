import ExpoModulesCore
import SwiftUI
import SmileID

// Enhanced SmartSelfie Authentication View using ExpoView
final class SmileIDSmartSelfieAuthenticationEnhancedView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: SmartSelfieEnrollmentDelegate
    private let hostingController: UIHostingController<EnhancedSmartSelfieAuthenticationView>
    private var config: SmartSelfieEnrollmentRequest?

    required init(appContext: AppContext? = nil) {
        delegate = SmartSelfieEnrollmentDelegate()
        hostingController = UIHostingController(
            rootView: EnhancedSmartSelfieAuthenticationView(
                delegate: delegate,
                config: nil
            )
        )
        super.init(appContext: appContext)

        // Set up delegate callbacks
        delegate.onResult = { [weak self] result in
            self?.onResult(result)
        }

        delegate.onError = { [weak self] error in
            self?.onError(["error": error.localizedDescription])
        }

        // Add the hosting controller's view
        addSubview(hostingController.view)
        hostingController.view.fillSuperview()
    }

    func updateConfig(_ config: SmartSelfieEnrollmentRequest) {
        self.config = config
        hostingController.rootView = EnhancedSmartSelfieAuthenticationView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID Enhanced SmartSelfie authentication view
struct EnhancedSmartSelfieAuthenticationView: View {
    let delegate: SmartSelfieEnrollmentDelegate
    let config: SmartSelfieEnrollmentRequest?

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
