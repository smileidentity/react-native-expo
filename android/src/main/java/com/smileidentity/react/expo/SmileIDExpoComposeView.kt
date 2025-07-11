package com.smileidentity.react.expo

import expo.modules.kotlin.views.ExpoView
import android.content.Context
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.size
import expo.modules.kotlin.AppContext

/**
 * A base class that should be used by compose views.
 * Borrowed from Expo library: https://github.com/expo/expo/blob/main/packages/expo-modules-core/android/src/compose/expo/modules/kotlin/views/ExpoComposeView.kt
 */
abstract class SmileIDExpoComposeView(
    context: Context,
    appContext: AppContext,
    private val withHostingView: Boolean = false
) : ExpoView(context, appContext) {

    @Composable
    abstract fun Content()

    override val shouldUseAndroidLayout = withHostingView

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (shouldUseAndroidLayout && !isAttachedToWindow) {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
            return
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    @Composable
    protected fun Children() {
        if (withHostingView) {
            return Content()
        }

        for (index in 0..<this.size) {
            val child = getChildAt(index) as? SmileIDExpoComposeView ?: continue
            child.Content()
        }
    }

    init {
        if (withHostingView) {
            addComposeView()
        } else {
            this.visibility = GONE
            this.setWillNotDraw(true)
        }
    }

    private fun addComposeView() {
        val composeView = ComposeView(context).also {
            it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            it.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            it.setContent {
                Children()
            }
            it.addOnAttachStateChangeListener(object : OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    it.disposeComposition()
                }

                override fun onViewDetachedFromWindow(v: View) {
                    it.disposeComposition()
                }
            })
        }
        addView(composeView)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeAllViews()
    }
}