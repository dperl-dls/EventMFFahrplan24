package event.pgm.fahrplan.emf2024.schedule.observables

import event.pgm.fahrplan.emf2024.models.DateInfos
import event.pgm.fahrplan.emf2024.models.ScheduleData
import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment
import event.pgm.fahrplan.emf2024.schedule.FahrplanViewModel

/**
 * Payload of the observable [scrollToCurrentSessionParameter][FahrplanViewModel.scrollToCurrentSessionParameter]
 * property in the [FahrplanViewModel] which is observed by the [FahrplanFragment].
 */
data class ScrollToCurrentSessionParameter(

    val scheduleData: ScheduleData,
    val dateInfos: DateInfos

)
