package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.Promise
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.smileidentity.models.Config


class SmileIDExpoModule : Module() {
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    override fun definition() = ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('SmileIDExpo')` in JavaScript.
        Name("SmileIDExpo")

        AsyncFunction("initialize") Coroutine { useSandBox: Boolean, enableCrashReporting: Boolean, config: SmileConfigRecord?, apiKey: String? ->
            val context = appContext.reactContext
                ?: throw IllegalStateException("Context is not available")

            withContext(Dispatchers.IO) {
                when {
                    // Case 1: Initialize with API key and config
                    apiKey != null && config != null -> {

                        val result = SmileID.initialize(
                            context = context,
                            config = config.toConfig(),
                            useSandbox = useSandBox,
                            enableCrashReporting = enableCrashReporting,
                            apiKey = apiKey
                        ).await()

                        result.getOrThrow()
                    }
                    // Case 2: Initialize with just config
                    config != null -> {
                        val result = SmileID.initialize(
                            context = context,
                            config = config.toConfig(),
                            useSandbox = useSandBox,
                            enableCrashReporting = enableCrashReporting,
                        ).await()

                        result.getOrThrow()
                    }
                    // Case 3: Basic initialization
                    else -> {
                        val result = SmileID.initialize(
                            context = context,
                            useSandbox = useSandBox,
                        ).await()
                        result.getOrThrow()
                    }
                }
            }
        }

        View(SmileIDDocumentVerificationView::class) {
            Events("onResult", "onError")
            Prop("config") { view: SmileIDDocumentVerificationView, config: SmileDocumentVerificationRequestRecord ->
                view.updateConfig(config)
            }


        }
        View(SmileIDSmartSelfieEnrollmentView::class) {
        }
    }
}
