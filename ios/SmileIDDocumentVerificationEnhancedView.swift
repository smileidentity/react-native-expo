import ExpoModulesCore
import SmileID
import SwiftUI

// Enhanced Document Verification View using ExpoView
final class SmileIDDocumentVerificationEnhancedView: ExpoView {
    let onResult = EventDispatcher()
    let onError = EventDispatcher()
    private let delegate: EnhancedDocumentVerificationDelegate
    private let hostingController: UIHostingController<EnhancedDocumentVerificationView>
    private var config: EnhancedDocumentVerificationRecord?

    required init(appContext: AppContext? = nil) {
        delegate = EnhancedDocumentVerificationDelegate()
        hostingController = UIHostingController(
            rootView: EnhancedDocumentVerificationView(
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

    func updateConfig(_ config: EnhancedDocumentVerificationRecord) {
        self.config = config
        hostingController.rootView = EnhancedDocumentVerificationView(
            delegate: delegate,
            config: config
        )
    }
}

// SwiftUI view that wraps the SmileID enhanced document verification screen
struct EnhancedDocumentVerificationView: View {
    let delegate: EnhancedDocumentVerificationDelegate
    let config: EnhancedDocumentVerificationRecord?

    var body: some View {
        if let config = config {
            SmileID.enhancedDocumentVerificationScreen(
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
                skipApiSubmission: config.skipApiSubmission,
                showAttribution: config.showAttribution,
                useStrictMode: config.useStrictMode,
                extraPartnerParams: config.extraPartnerParams,
                consentInformation: ConsentInformation(
                    consented: ConsentedInformation(
                        consentGrantedDate: config.consentInformationRequest?.consentGrantedDate ?? Date().toISO8601WithMilliseconds(),
                        personalDetails: config.consentInformationRequest?.personalDetails ?? false,
                        contactInformation: config.consentInformationRequest?.contactInformation ?? false,
                        documentInformation: config.consentInformationRequest?.documentInformation ?? false
                    )
                ),
                delegate: delegate
            )
        } else {
            Text("Configuration not provided")
                .foregroundColor(.red)
        }
    }
}


// Delegate class for enhanced document verification
class EnhancedDocumentVerificationDelegate: EnhancedDocumentVerificationResultDelegate {
    var onResult: (([String: Any]) -> Void)?
    var onError: ((Error) -> Void)?

    func didSucceed(
        selfie: URL,
        documentFrontImage: URL,
        documentBackImage: URL?,
        didSubmitEnhancedDocVJob: Bool
    ) {
        var params: [String: Any] = [
            "selfie": selfie.absoluteString,
            "documentFrontFile": documentFrontImage.absoluteString,
            "didSubmitEnhancedDocVJob": didSubmitEnhancedDocVJob,
        ]
        if let documentBackImage {
            params["documentBackFile"] = documentBackImage.absoluteString
        }
        onResult?(params)
    }

    func didError(error: Error) {
        onError?(error)
    }
}
