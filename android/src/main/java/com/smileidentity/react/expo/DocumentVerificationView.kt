package com.smileidentity.react.expo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smileidentity.SmileID
import com.smileidentity.compose.DocumentVerification
import timber.log.Timber

/**
 * Compose view that wraps the SmileID document verification screen
 **/
@Composable
fun DocumentVerificationView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
    ) {
        SmileID.DocumentVerification(
            countryCode = "KE"
        ) { result ->
            Timber.d("DocumentVerification result: $result")
        }
    }
}