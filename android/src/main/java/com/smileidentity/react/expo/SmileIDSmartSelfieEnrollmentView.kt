package com.smileidentity.react.expo

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smileidentity.SmileID
import com.smileidentity.compose.SmartSelfieEnrollment
import expo.modules.kotlin.AppContext
import timber.log.Timber

/**
 * Document Verification View using ExpoView
 **/
class SmileIDSmartSelfieEnrollmentView(context: Context, appContext: AppContext) :
    SmileIDExpoComposeView(
        context = context,
        appContext = appContext,
        withHostingView = true
    ) {

    @Composable
    override fun Content() {
        SmartSelfieEnrollmentView()
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
