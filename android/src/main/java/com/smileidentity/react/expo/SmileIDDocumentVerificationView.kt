package com.smileidentity.react.expo

import android.content.Context
import androidx.compose.ui.platform.ComposeView
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

/**
 * SmartSelfie Enrollment View using ExpoView
 **/
class SmileIDDocumentVerificationView(context: Context, appContext: AppContext) :
    ExpoView(context, appContext) {
    internal val composeView = ComposeView(context).also {

        it.layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        it.setContent {
            DocumentVerificationView()
        }
        addView(it)
    }
}