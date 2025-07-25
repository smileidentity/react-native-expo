package com.smileidentity.react.expo

import com.smileidentity.SmileID
import expo.modules.kotlin.functions.Coroutine
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.smileidentity.metadata.models.WrapperSdkName

class SmileIDExpoModule : Module() {
    override fun definition() = ModuleDefinition {
        Name("SmileIDExpo")

        AsyncFunction("initialize") Coroutine { useSandBox: Boolean, enableCrashReporting: Boolean, config: SmileConfigRecord?, apiKey: String? ->
            val context = appContext.reactContext
                ?: throw IllegalStateException("Context is not available")

            withContext(Dispatchers.IO) {
                SmileID.setWrapperInfo(WrapperSdkName.ReactNative, "11.0.0")

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
            Prop("params") { view: SmileIDDocumentVerificationView, config: DocumentVerificationRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDDocumentVerificationEnhancedView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDDocumentVerificationEnhancedView, config: EnhancedDocumentVerificationRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDSmartSelfieEnrollmentView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDSmartSelfieEnrollmentView, config: SmartSelfieRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDSmartSelfieEnrollmentEnhancedView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDSmartSelfieEnrollmentEnhancedView, config: SmartSelfieRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDSmartSelfieAuthenticationView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDSmartSelfieAuthenticationView, config: SmartSelfieRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDSmartSelfieAuthenticationEnhancedView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDSmartSelfieAuthenticationEnhancedView, config: SmartSelfieRecord ->
                view.updateConfig(config)
            }
        }

        View(SmileIDBiometricKYCView::class) {
            Events("onResult", "onError")
            Prop("params") { view: SmileIDBiometricKYCView, config: BiometricKYCRecord ->
                view.updateConfig(config)
            }
        }
    }
}
