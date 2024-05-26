@file:JvmName("LockScreenHelper")

package event.pgm.fahrplan.emf2024.utils

import android.app.Activity
import android.os.Build
import android.view.WindowManager

/**
 * Enables this [Activity][this] to be shown on top of the lock screen whenever the lock screen
 * is up and the [Activity] is resumed.
 */
fun Activity.showWhenLockedCompat() {
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
        setShowWhenLocked(true)
    } else {
        @Suppress("DEPRECATION")
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
    }
}
