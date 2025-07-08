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
    private val onSuccess by EventDispatcher()
    private val onError by EventDispatcher()

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
                DocumentVerificationView(
                    props = props.value,
                    onSuccess = { result ->
                        onSuccess(
                            mapOf(
                                "result" to Json.encodeToString(result)
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
            userId = config.userId
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
    onSuccess: (DocumentVerificationResult) -> Unit,
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
            userId = props.userId,
            jobId = props.jobId
        ) { result ->
            when (result) {
                is SmileIDResult.Success -> {
                    onSuccess(result.data)
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
    val jobId: String = ""
)