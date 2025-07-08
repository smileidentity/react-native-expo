package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.Promise
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import expo.modules.kotlin.records.Record
import expo.modules.kotlin.records.Field
import com.smileidentity.models.Config

/**
 * Type‑safe bridge for the JS `ExpoConfig` object coming from JavaScript.
 */
class SmileConfigRecord : Record {
    @Field
    var partnerId: String = ""

    @Field
    var authToken: String = ""

    @Field
    var prodLambdaUrl: String = ""

    @Field
    var testLambdaUrl: String = ""
}

class SmileIDExpoModule : Module() {
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        AsyncFunction("initialize") Coroutine { config: SmileConfigRecord, useSandBox: Boolean, enableCrashReporting: Boolean, apiKey: String ->
            val context = appContext.reactContext
                ?: throw IllegalStateException("Context is not available")

            // Map the record to the SDK's expected Config data class
            val smileConfig = Config(
                partnerId      = config.partnerId,
                authToken      = config.authToken,
                prodLambdaUrl  = config.prodLambdaUrl,
                testLambdaUrl  = config.testLambdaUrl
            )

            withContext(Dispatchers.IO) {
                SmileID.initialize(
                    context               = context,
                    config                = smileConfig,
                    useSandbox            = useSandBox,
                    enableCrashReporting  = enableCrashReporting,
                    apiKey                = apiKey
                ).await()
            }
        }

        View(SmileIDDocumentVerificationView::class) {

        }
        View(SmileIDSmartSelfieEnrollmentView::class) {
        }
    }
}
