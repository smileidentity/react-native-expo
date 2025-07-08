import ExpoModulesCore
import SmileID
import SwiftUI

// Document Verification View using ExpoView
final class SmileIDDocumentVerificationView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: DocumentVerificationDelegate
    private let hostingController: UIHostingController<DocumentVerificationView>
    private var config: DocumentVerificationRequest?

    required init(appContext: AppContext? = nil) {
        delegate = DocumentVerificationDelegate()
        hostingController = UIHostingController(
            rootView: DocumentVerificationView(
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

    func updateConfig(_ config: DocumentVerificationRequest) {
        self.config = config
        hostingController.rootView = DocumentVerificationView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID document verification screen
struct DocumentVerificationView: View {
    let delegate: DocumentVerificationDelegate
    let config: DocumentVerificationRequest?

    var body: some View {
        if let config = config {
            SmileID.documentVerificationScreen(
                userId: config.userId ?? generateUserId(),
                jobId: config.jobId ?? generateJobId(),
                allowNewEnroll: config.allowNewEnroll,
                countryCode: config.countryCode,
                documentType: config.documentType,
                idAspectRatio: config.idAspectRatio,
                bypassSelfieCaptureWithFile: config.bypassSelfieCaptureWithFile.flatMap(URL.init),
                enableAutoCapture: config.enableAutoCapture,
                captureBothSides: config.captureBothSides,
                allowAgentMode: config.allowAgentMode,
                allowGalleryUpload: config.allowGalleryUpload,
                showInstructions: config.showInstructions,
                showAttribution: config.showAttribution,
                skipApiSubmission: config.skipApiSubmission,
                useStrictMode: config.useStrictMode,
                extraPartnerParams: config.extraPartnerParams,
                delegate: delegate
            )
        } else {
            Text("Configuration not provided")
                .foregroundColor(.red)
        }
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
            "didSubmitDocumentVerificationJob": didSubmitDocumentVerificationJob,
        ]
        onResult?(result)
    }

    func didError(error: Error) {
        onError?(error)
    }
}
