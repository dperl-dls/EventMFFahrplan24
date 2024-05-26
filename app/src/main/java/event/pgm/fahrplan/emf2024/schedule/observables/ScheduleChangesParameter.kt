package event.pgm.fahrplan.emf2024.schedule.observables

import event.pgm.fahrplan.emf2024.changes.ChangeStatistic
import event.pgm.fahrplan.emf2024.schedule.MainActivity
import event.pgm.fahrplan.emf2024.schedule.MainViewModel

/**
 * Payload of the observable [scheduleChangesParameter][MainViewModel.scheduleChangesParameter]
 * property in the [MainViewModel] which is observed by the [MainActivity].
 */
data class ScheduleChangesParameter(

    val scheduleVersion: String,
    val changeStatistic: ChangeStatistic

)
