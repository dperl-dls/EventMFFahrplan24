package event.pgm.fahrplan.emf2024.alarms

sealed interface AlarmsState {

    data object Loading : AlarmsState

    data class Success(
        val sessionAlarmParameters: List<SessionAlarmParameter>,
        val onItemClick: (SessionAlarmParameter) -> Unit,
        val onDeleteItemClick: (SessionAlarmParameter) -> Unit,
    ) : AlarmsState

}
