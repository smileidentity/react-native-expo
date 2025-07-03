import ExpoModulesCore
import SwiftUI
import SmileID

// Document Verification View using ExpoView
final class SmileIDDocumentVerificationView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: DocumentVerificationDelegate
    private let hostingController: UIHostingController<DocumentVerificationView>

    required init(appContext: AppContext? = nil) {
        delegate = DocumentVerificationDelegate()
        hostingController = UIHostingController(rootView: DocumentVerificationView(delegate: delegate))
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

// SwiftUI view that wraps the SmileID document verification screen
struct DocumentVerificationView: View {
    let delegate: DocumentVerificationDelegate
    
    var body: some View {
        SmileID.documentVerificationScreen(countryCode: "KE", delegate: delegate)
    }
}

// Delegate class for document verification
class DocumentVerificationDelegate: DocumentVerificationResultDelegate {
    var onResult: (([String: Any]) -> Void)?
    var onError: ((Error) -> Void)?
    
    func didSucceed(
        selfie: URL,
        documentFrontImage: URL,
        documentBackImage: URL?,
        didSubmitDocumentVerificationJob: Bool
    ) {
        let result: [String: Any] = [
            "selfie": selfie.absoluteString,
            "documentFrontImage": documentFrontImage.absoluteString,
            "documentBackImage": documentBackImage?.absoluteString ?? NSNull(),
            "didSubmitDocumentVerificationJob": didSubmitDocumentVerificationJob
        ]
        onResult?(result)
    }
    
    func didError(error: Error) {
        onError?(error)
    }
}
