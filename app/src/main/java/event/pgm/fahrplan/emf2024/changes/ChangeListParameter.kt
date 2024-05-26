package event.pgm.fahrplan.emf2024.changes

import event.pgm.fahrplan.emf2024.models.Session

/**
 * Payload of the observable property in the [ChangeListViewModel]
 * which is observed by the [ChangeListFragment].
 */
data class ChangeListParameter(

    val sessions: List<Session>,
    val numDay: Int,
    val useDeviceTimeZone: Boolean

)
