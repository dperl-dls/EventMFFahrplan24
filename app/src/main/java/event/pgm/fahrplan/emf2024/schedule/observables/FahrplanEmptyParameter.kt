package event.pgm.fahrplan.emf2024.schedule.observables

import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment
import event.pgm.fahrplan.emf2024.schedule.FahrplanViewModel

/**
 * Payload of the observable [fahrplanEmptyParameter][FahrplanViewModel.fahrplanEmptyParameter]
 * property in the [FahrplanViewModel] which is observed by the [FahrplanFragment].
 */
data class FahrplanEmptyParameter(

    val scheduleVersion: String

)
