import ExpoModulesCore
import SwiftUI
import SmileID

// SmartSelfie Enrollment View using ExpoView
final class SmileIDSmartSelfieEnrollmentView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: SmartSelfieEnrollmentDelegate
    private let hostingController: UIHostingController<SmartSelfieEnrollmentView>

    required init(appContext: AppContext? = nil) {
        delegate = SmartSelfieEnrollmentDelegate()
        hostingController = UIHostingController(rootView: SmartSelfieEnrollmentView(delegate: delegate))
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
}

// SwiftUI view that wraps the SmileID SmartSelfie enrollment screen
struct SmartSelfieEnrollmentView: View {
    let delegate: SmartSelfieEnrollmentDelegate
    
    var body: some View {
        SmileID.smartSelfieEnrollmentScreen(
            userId: "user_id",
            delegate: delegate
        )
    }
}

// Delegate class for SmartSelfie enrollment
class SmartSelfieEnrollmentDelegate: SmartSelfieResultDelegate {
    var onResult: (([String: Any]) -> Void)?
    var onError: ((Error) -> Void)?
    
    func didSucceed(
        selfieImage: URL,
        livenessImages: [URL],
        apiResponse: SmartSelfieResponse?
    ) {
    }
    
    func didSucceed(
        selfie: URL,
        livenessImages: [URL],
        didSubmitSmartSelfieJob: Bool
    ) {
        let result: [String: Any] = [
            "selfie": selfie.absoluteString,
            "livenessImages": livenessImages.map { $0.absoluteString },
            "didSubmitSmartSelfieJob": didSubmitSmartSelfieJob
        ]
        onResult?(result)
    }
    
    func didError(error: Error) {
        onError?(error)
    }
}
