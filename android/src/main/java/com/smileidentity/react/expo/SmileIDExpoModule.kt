package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SmileIDExpoModule : Module() {
    override fun definition() = ModuleDefinition {
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
            Events("onResult", "onError")
            Prop("config") { view: SmileIDSmartSelfieEnrollmentView, config: SmartSelfieEnrollmentRequest ->
                view.updateConfig(config)
            }
        }
    }
}
