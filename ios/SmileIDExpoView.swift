import ExpoModulesCore
import SwiftUI
import UIKit
import WebKit
import SmileID

// This view will be used as a native component. Make sure to inherit from `ExpoView`
// to apply the proper styling (e.g. border radius and shadows).
class SmileIDExpoView: ExpoView {
  let webView = WKWebView()
  let onLoad = EventDispatcher()
  var delegate: WebViewDelegate?
  private let contentView: UIHostingController<DocV>

  required init(appContext: AppContext? = nil) {
    contentView = UIHostingController(rootView: DocV())
    super.init(appContext: appContext)
    clipsToBounds = true
    addSubview(contentView.view)
  }

  override func layoutSubviews() {
    webView.frame = bounds
  }
}

class WebViewDelegate: NSObject, WKNavigationDelegate {
  let onUrlChange: (String) -> Void

  init(onUrlChange: @escaping (String) -> Void) {
    self.onUrlChange = onUrlChange
  }

  func webView(_ webView: WKWebView, didFinish navigation: WKNavigation) {
    if let url = webView.url {
      onUrlChange(url.absoluteString)
    }
  }
}

struct DocV : View {
    var body: some View {
        SmileID.documentVerificationScreen(countryCode: "KE", delegate: SmileIDDocumentVerificationView())
    }
}

class SmileIDDocumentVerificationView: DocumentVerificationResultDelegate {
    func didSucceed(selfie: URL, documentFrontImage: URL, documentBackImage: URL?, didSubmitDocumentVerificationJob: Bool) {

    }
    
    func didError(error: any Error) {

    }
}
