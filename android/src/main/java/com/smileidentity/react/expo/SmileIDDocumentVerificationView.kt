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
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
        props.value = props.value.copy(
            countryCode = config.countryCode,
            jobId = config.jobId,
            userId = config.userId,
            captureBothSides = config.captureBothSides
        )
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
            countryCode = props.countryCode,
            captureBothSides = props.captureBothSides
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
    val countryCode: String = "",
    val userId: String = "",
    val jobId: String = "",
    val captureBothSides: Boolean = true
)