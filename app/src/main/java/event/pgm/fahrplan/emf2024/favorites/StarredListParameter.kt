package event.pgm.fahrplan.emf2024.favorites

import event.pgm.fahrplan.emf2024.models.Session

data class StarredListParameter(

    val sessions: List<Session>,
    val numDay: Int,
    val useDeviceTimeZone: Boolean

)
