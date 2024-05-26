package event.pgm.fahrplan.emf2024.alarms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import event.pgm.fahrplan.emf2024.alarms.AlarmsState.Loading
import event.pgm.fahrplan.emf2024.alarms.AlarmsState.Success
import event.pgm.fahrplan.emf2024.commons.ScreenNavigation
import event.pgm.fahrplan.emf2024.dataconverters.toSchedulableAlarm
import event.pgm.fahrplan.emf2024.models.SchedulableAlarm
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.repositories.ExecutionContext

internal class AlarmsViewModel(

    private val repository: AppRepository = AppRepository,
    private val executionContext: ExecutionContext,
    private val alarmServices: AlarmServices,
    private val screenNavigation: ScreenNavigation,
    private val alarmsStateFactory: AlarmsStateFactory,

) : ViewModel() {

    private val useDeviceTimeZone: Boolean
        get() = repository.readUseDeviceTimeZoneEnabled()

    private val mutableAlarmsState = MutableStateFlow<AlarmsState>(Loading)
    val alarmsState = mutableAlarmsState.asStateFlow()

    init {
        combine(repository.alarms, repository.sessions) { alarms, sessions ->
            mutableAlarmsState.value = Success(
                sessionAlarmParameters = alarmsStateFactory
                    .createAlarmsState(alarms, sessions, useDeviceTimeZone),
                onItemClick = ::navigateToSessionDetails,
                onDeleteItemClick = ::deleteSessionAlarm
            )
        }.launchIn(viewModelScope)
    }

    private fun navigateToSessionDetails(value: SessionAlarmParameter) {
        screenNavigation.navigateToSessionDetails(value.sessionId)
    }

    private fun deleteSessionAlarm(value: SessionAlarmParameter) {
        launch {
            repository.deleteAlarmForSessionId(value.sessionId)
            val alarm = SchedulableAlarm(
                day = value.dayIndex,
                sessionId = value.sessionId,
                sessionTitle = value.title,
                startTime = value.firesAt
            )
            alarmServices.discardSessionAlarm(alarm)
        }
    }

    fun onDeleteAllClick() {
        launch {
            val alarms = repository.readAlarms()
            alarms
                .map { it.toSchedulableAlarm() }
                .forEach { alarmServices.discardSessionAlarm(it) }
            if (alarms.isNotEmpty()) {
                repository.deleteAllAlarms()
            }
        }
    }

    private fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(executionContext.database, block = block)
    }

}
