package event.pgm.fahrplan.emf2024.commons

import android.content.Context
import event.pgm.fahrplan.emf2024.extensions.openMap

class ExternalNavigator(val context: Context) : ExternalNavigation {

    override fun openMap(locationText: String) = context.openMap(locationText)

}
