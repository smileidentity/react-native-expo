package com.smileidentity.react.expo

import android.content.Context
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.smileidentity.SmileID
import com.smileidentity.compose.DocumentVerification
import com.smileidentity.results.DocumentVerificationResult
import com.smileidentity.results.SmileIDResult
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.views.ExpoView
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

/**
 * SmartSelfie Enrollment View using ExpoView
 **/
class SmileIDDocumentVerificationView(context: Context, appContext: AppContext) :
    ExpoView(context, appContext) {
    private var composeView: ComposeView? = null
    private var props = mutableStateOf(DocumentVerificationProps())
    private val onResult by EventDispatcher()
    private val onError by EventDispatcher()

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
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
            addView(it)
            composeView = it
        }
    }

    fun updateConfig(config: SmileDocumentVerificationRequestRecord) {
        props.value = config.toDocumentVerificationProps()
    }
}

/**
 * Compose view that wraps the SmileID document verification screen
 * @param props
 **/
@Composable
fun DocumentVerificationView(
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
    val allowNewEnroll: Boolean = true,
    val documentType: String = "",
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
    val extraParams: ImmutableMap<String, String> = persistentMapOf()
)