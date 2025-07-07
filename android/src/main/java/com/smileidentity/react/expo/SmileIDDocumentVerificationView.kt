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
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView
import timber.log.Timber

/**
 * SmartSelfie Enrollment View using ExpoView
 **/
class SmileIDDocumentVerificationView(context: Context, appContext: AppContext) :
    ExpoView(context, appContext) {
    private var composeView: ComposeView? = null
    private var props = mutableStateOf(DocumentVerificationProps())

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
                DocumentVerificationView(
                    props = props.value
                )
            }
            addView(it)
            composeView = it
        }
    }

    fun setCountryCode(countryCode: String) {
        props.value = props.value.copy(countryCode = countryCode)
    }

    fun setJobId(jobId: String) {
        props.value = props.value.copy(jobId = jobId)
    }

    fun setUserId(userId: String) {
        props.value = props.value.copy(userId = userId)
    }
}

/**
 * Compose view that wraps the SmileID document verification screen
 * @param props
 **/
@Composable
fun DocumentVerificationView(
    props: DocumentVerificationProps
) {
    Timber.d("Here with props: ${props.countryCode}")
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
            Timber.d("DocumentVerification result: $result")
        }
    }
}


data class DocumentVerificationProps(
    val countryCode: String = "",
    val userId: String = "",
    val jobId: String = ""
)