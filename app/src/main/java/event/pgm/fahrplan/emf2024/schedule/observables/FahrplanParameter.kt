package event.pgm.fahrplan.emf2024.schedule.observables

import event.pgm.fahrplan.emf2024.models.ScheduleData
import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment
import event.pgm.fahrplan.emf2024.schedule.FahrplanViewModel

/**
 * Payload of the observable [fahrplanParameter][FahrplanViewModel.fahrplanParameter] property
 * in the [FahrplanViewModel] which is observed by the [FahrplanFragment].
 */
data class FahrplanParameter(

    val scheduleData: ScheduleData,
    val useDeviceTimeZone: Boolean,
    val numDays: Int,
    val dayIndex: Int,
    val dayMenuEntries: List<String>

)
