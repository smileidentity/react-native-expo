package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.core.Promise
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class SmileIDExpoModule : Module() {
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        Function("initialize") { useSandBox: Boolean, enableCrashReporting: Boolean, apiKey: String?, promise: Promise ->

            try {
                val context = appContext.reactContext?.applicationContext!!
                SmileID.initialize(context)
                promise.resolve(null) // Resolving with void
            } catch (e: Exception) {
                promise.reject("INITIALIZATION_ERROR", e.localizedMessage, e)
            }
        }

        View(SmileIDDocumentVerificationView::class) {

        }
        View(SmileIDSmartSelfieEnrollmentView::class) {
        }
    }
}
