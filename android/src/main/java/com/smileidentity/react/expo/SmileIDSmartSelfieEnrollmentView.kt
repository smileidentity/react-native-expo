package com.smileidentity.react.expo

import android.content.Context
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.smileidentity.SmileID
import com.smileidentity.compose.SmartSelfieEnrollment
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView
import timber.log.Timber

/**
 * Document Verification View using ExpoView
 **/
class SmileIDSmartSelfieEnrollmentView(context: Context, appContext: AppContext) :
    ExpoView(context, appContext) {
    private var composeView: ComposeView? = null

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
                SmartSelfieEnrollmentView()
            }
            addView(it)
            composeView = it
        }
    }
}

/**
 * Compose view that wraps the SmileID SmartSelfie enrollment screen
 **/
@Composable
fun SmartSelfieEnrollmentView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        SmileID.SmartSelfieEnrollment(
            userId = "user_id"
        ) { result ->
            Timber.d("SmartSelfieEnrollment result: $result")
        }
    }
}