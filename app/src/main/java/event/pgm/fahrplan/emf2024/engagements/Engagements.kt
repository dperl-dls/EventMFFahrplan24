@file:JvmName("Engagements")

package event.pgm.fahrplan.emf2024.engagements

import androidx.appcompat.app.AppCompatActivity
import event.pgm.fahrplan.emf2024.BuildConfig
import event.pgm.fahrplan.emf2024.navigation.C3navSnack
import org.ligi.snackengage.SnackEngage

@Suppress("ConstantConditionIf")
fun AppCompatActivity.initUserEngagement() {
    val snackEngageBuilder = SnackEngage.from(this)
    if (BuildConfig.ENGAGE_GOOGLE_PLAY_RATING) {
        snackEngageBuilder.withSnack(RateSnack(this))
    }
    if (BuildConfig.ENGAGE_GOOGLE_BETA_TESTING) {
        snackEngageBuilder.withSnack(GooglePlayBetaTestingSnack(this))
    }
    if (BuildConfig.ENGAGE_C3NAV_APP_INSTALLATION) {
        snackEngageBuilder.withSnack(C3navSnack(this))
    }
    if (BuildConfig.ENGAGE_LANDSCAPE_ORIENTATION) {
        snackEngageBuilder.withSnack(LandscapeOrientationSnack(this))
    }
    snackEngageBuilder
            .build()
            .engageWhenAppropriate()
}
