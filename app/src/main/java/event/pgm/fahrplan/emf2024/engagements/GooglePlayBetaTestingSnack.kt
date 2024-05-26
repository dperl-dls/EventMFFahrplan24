package event.pgm.fahrplan.emf2024.engagements

import android.content.Context
import androidx.core.content.ContextCompat
import event.pgm.fahrplan.emf2024.R
import org.ligi.snackengage.conditions.AfterNumberOfOpportunities
import org.ligi.snackengage.conditions.NeverAgainWhenClickedOnce
import org.ligi.snackengage.conditions.connectivity.IsConnectedViaWiFiOrUnknown
import org.ligi.snackengage.snacks.GooglePlayOpenBetaTestSnack

class GooglePlayBetaTestingSnack(val context: Context) : GooglePlayOpenBetaTestSnack() {

    init {
        overrideTitleText(context.getString(R.string.snack_engage_google_play_beta_testing_title))
        overrideActionText(context.getString(R.string.snack_engage_google_play_beta_testing_action))
        withConditions(
                NeverAgainWhenClickedOnce(),
                AfterNumberOfOpportunities(21),
                IsConnectedViaWiFiOrUnknown(),
                IsInstalledViaGooglePlay(), // Prevents the snack from being shown for local installs, too!
        )
        setActionColor(ContextCompat.getColor(context, R.color.colorAccent))
    }

}
