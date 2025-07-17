package com.smileidentity.react.expo

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.smileidentity.SmileID
import com.smileidentity.compose.EnhancedDocumentVerificationScreen
import com.smileidentity.results.EnhancedDocumentVerificationResult
import com.smileidentity.results.SmileIDResult
import com.smileidentity.util.randomJobId
import com.smileidentity.util.randomUserId
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher

/**
 * Document Verification Enhanced View using ExpoView
 */
class SmileIDDocumentVerificationEnhancedView(context: Context, appContext: AppContext) :
    SmileIDExpoComposeView(
        context = context,
        appContext = appContext,
        shouldHostComposeContent = true
    ) {
    private var props = mutableStateOf(DocumentVerificationProps())
    private val onResult by EventDispatcher()
    private val onError by EventDispatcher()

    fun updateConfig(config: EnhancedDocumentVerificationRequest) {
        props.value = config.toDocumentVerificationProps()
    }

    @Composable
    override fun Content() {
        EnhancedDocumentVerificationView(
            props = props.value,
            onResult = { result ->
                onResult(
                    mapOf(
                        "documentFrontFile" to result.documentFrontFile.toString(),
                        "documentBackFile" to result.documentBackFile.toString(),
                        "selfieFile" to result.selfieFile.toString(),
                    )
                )
            },
            onError = { error ->
                onError(
                    mapOf(
                        "error" to error.localizedMessage.toString()
                    )
                )
            }
        )
    }
}

/**
 * Compose view that wraps the SmileID enhanced document verification view
 **/
@Composable
fun EnhancedDocumentVerificationView(
    props: DocumentVerificationProps,
    onResult: (EnhancedDocumentVerificationResult) -> Unit,
    onError: (Throwable) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        SmileID.EnhancedDocumentVerificationScreen(
            userId = props.userId ?: randomUserId(),
            jobId = props.jobId ?: randomJobId(),
            allowNewEnroll = props.allowNewEnroll,
            countryCode = props.countryCode,
            documentType = props.documentType,
            idAspectRatio = props.idAspectRatio,
            bypassSelfieCaptureWithFile = props.bypassSelfieCaptureWithFile,
            enableAutoCapture = props.enableAutoCapture,
            captureBothSides = props.captureBothSides,
            allowAgentMode = props.allowAgentMode,
            allowGalleryUpload = props.allowGalleryUpload,
            showInstructions = props.showInstructions,
            showAttribution = props.showAttribution,
            useStrictMode = props.useStrictMode,
            extraPartnerParams = props.extraParams,
            consentInformation = props.consentInformation
        ) { result ->
            when (result) {
                is SmileIDResult.Success -> {
                    onResult(result.data)
                }
                is SmileIDResult.Error -> {
                    onError(result.throwable)
                }
            }

        }
    }
}