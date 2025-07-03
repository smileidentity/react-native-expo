import ExpoModulesCore
import SmileID

public class SmileIDExpoModule: Module {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  public func definition() -> ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
    Name("SmileIDExpo")

    // Defines a JavaScript function that always returns a Promise and whose native code
    // is by default dispatched on the different thread than the JavaScript runtime runs on.
    AsyncFunction("initalize") { (
        useSandBox: Bool,
        enableCrashReporting: Bool,
        apiKey: String?
    ) -> Void in
     SmileID.initialize(
      apiKey: apiKey,
      useSandbox: useSandBox
     )
    }

    // Enables the module to be used as a native view. Definition components that are accepted as part of the
    // view definition: Prop, Events.
    View(SmileIDExpoView.self) {
      // Defines a setter for the `url` prop.
      Prop("url") { (view: SmileIDExpoView, url: URL) in
        if view.webView.url != url {
          view.webView.load(URLRequest(url: url))
        }
      }

      Events("onLoad")
    }
  }
}
