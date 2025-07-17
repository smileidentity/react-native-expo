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
import com.smileidentity.compose.DocumentVerification
import com.smileidentity.models.ConsentInformation
import com.smileidentity.models.ConsentedInformation
import com.smileidentity.results.DocumentVerificationResult
import com.smileidentity.results.SmileIDResult
import com.smileidentity.util.randomJobId
import com.smileidentity.util.randomUserId
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentMapOf
import java.io.File

/**
 * Document Verification View using ExpoView
 **/
class SmileIDDocumentVerificationView(context: Context, appContext: AppContext) :
    SmileIDExpoComposeView(
        context = context,
        appContext = appContext,
        shouldHostComposeContent = true
    ) {
    private var props = mutableStateOf(DocumentVerificationProps())
    private val onResult by EventDispatcher()
    private val onError by EventDispatcher()

    fun updateConfig(config: DocumentVerificationRequest) {
        props.value = config.toDocumentVerificationProps()
    }

    @Composable
    override fun Content() {
        DocumentVerificationView(
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
 * Compose view that wraps the SmileID document verification view
 **/
@Composable
private fun DocumentVerificationView(
    props: DocumentVerificationProps,
    onResult: (DocumentVerificationResult) -> Unit,
    onError: (Throwable) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        SmileID.DocumentVerification(
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
            extraPartnerParams = props.extraParams
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


data class DocumentVerificationProps(
    val userId: String? = null,
    val jobId: String? = null,
    val countryCode: String = "",
    val allowNewEnroll: Boolean = false,
    val documentType: String? = null,
    val idAspectRatio: Float? = null,
    val bypassSelfieCaptureWithFile: File? = null,
    val enableAutoCapture: Boolean = true,
    val captureBothSides: Boolean = true,
    val allowAgentMode: Boolean = false,
    val allowGalleryUpload: Boolean = false,
    val showInstructions: Boolean = true,
    val showAttribution: Boolean = true,
    val skipApiSubmission: Boolean = false,
    val useStrictMode: Boolean = false,
    val extraParams: ImmutableMap<String, String> = persistentMapOf(),
    val consentInformation: ConsentInformation = ConsentInformation(
        consented = ConsentedInformation (
            consentGrantedDate = getCurrentIsoTimestamp(),
            personalDetails = false,
            contactInformation = false,
            documentInformation = false
        )
    )
)