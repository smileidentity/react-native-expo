import ExpoModulesCore
import SwiftUI
import SmileID

// SmartSelfie Authentication View using ExpoView
final class SmileIDSmartSelfieAuthenticationView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: SmartSelfieEnrollmentDelegate
    private let hostingController: UIHostingController<SmartSelfieAuthenticationView>
    private var config: SmartSelfieEnrollmentRequest?

    required init(appContext: AppContext? = nil) {
        delegate = SmartSelfieEnrollmentDelegate()
        hostingController = UIHostingController(
            rootView: SmartSelfieAuthenticationView(
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
        hostingController.rootView = SmartSelfieAuthenticationView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID SmartSelfie authentication view
struct SmartSelfieAuthenticationView: View {
    let delegate: SmartSelfieEnrollmentDelegate
    let config: SmartSelfieEnrollmentRequest?

    var body: some View {
        if let config = config {
            SmileID.smartSelfieAuthenticationScreen(
                userId: config.userId ?? generateUserId(),
                jobId: config.jobId ?? generateJobId(),
                allowNewEnroll: config.allowNewEnroll,
                allowAgentMode: config.allowAgentMode,
                showAttribution: config.showAttribution,
                showInstructions: config.showInstructions,
                useStrictMode: config.useStrictMode,
                skipApiSubmission: config.skipApiSubmission,
                extraPartnerParams: config.extraPartnerParams,
                delegate: delegate
            )
        } else {
            Text("Configuration not provided").foregroundColor(.red)
        }
    }
}
