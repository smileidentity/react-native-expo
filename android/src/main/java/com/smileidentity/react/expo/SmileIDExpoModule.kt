package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.Promise
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SmileIDExpoModule : Module() {
    
    // Helper function to convert SmileIDConfig to SmileID.Config
    private fun convertToSmileIDConfig(config: SmileIDConfig): com.smileidentity.Config {
        return com.smileidentity.Config(
            partnerId = config.partnerId,
            authToken = config.authToken,
            prodLambdaUrl = config.prodLambdaUrl,
            testLambdaUrl = config.testLambdaUrl
        )
    }
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        AsyncFunction("initialize") Coroutine { config: SmileIDConfig, useSandBox: Boolean, enableCrashReporting: Boolean, apiKey: String? ->
            val context = appContext.reactContext
                ?: throw IllegalStateException("Context is not available")

            withContext(Dispatchers.IO) {
                // Convert SmileIDConfig to com.smileidentity.Config
                val smileConfig = convertToSmileIDConfig(config)
                
                SmileID.initialize(
                    context,
                    smileConfig,
                    useSandBox
                ).await()
            }
        }

        View(SmileIDDocumentVerificationView::class) {

        }
        View(SmileIDSmartSelfieEnrollmentView::class) {
        }
    }
}
