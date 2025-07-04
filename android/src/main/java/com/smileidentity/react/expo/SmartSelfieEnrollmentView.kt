package com.smileidentity.react.expo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smileidentity.SmileID
import com.smileidentity.compose.SmartSelfieEnrollment
import timber.log.Timber

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