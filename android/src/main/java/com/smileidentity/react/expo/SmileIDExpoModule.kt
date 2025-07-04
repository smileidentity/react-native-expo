package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.Promise
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SmileIDExpoModule : Module() {
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        AsyncFunction("initialize") Coroutine { useSandBox: Boolean, enableCrashReporting: Boolean, apiKey: String? ->
            val context = appContext.reactContext
                ?: throw IllegalStateException("Context is not available")

            withContext(Dispatchers.IO) {
                SmileID.initialize(
                    context
                ).await()
            }
        }

        View(SmileIDDocumentVerificationView::class) {

        }
        View(SmileIDSmartSelfieEnrollmentView::class) {
        }
    }
}
