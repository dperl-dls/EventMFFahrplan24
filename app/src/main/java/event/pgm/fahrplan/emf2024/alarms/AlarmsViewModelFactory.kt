package event.pgm.fahrplan.emf2024.alarms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import event.pgm.fahrplan.emf2024.commons.ResourceResolving
import event.pgm.fahrplan.emf2024.commons.ScreenNavigation
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext
import event.pgm.fahrplan.emf2024.repositories.AppRepository

internal class AlarmsViewModelFactory(

    private val appRepository: AppRepository,
    private val resourceResolving: ResourceResolving,
    private val alarmServices: AlarmServices,
    private val screenNavigation: ScreenNavigation,

    ) : Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return AlarmsViewModel(
            repository = appRepository,
            executionContext = AppExecutionContext,
            alarmServices = alarmServices,
            screenNavigation = screenNavigation,
            alarmsStateFactory = AlarmsStateFactory(resourceResolving),
        ) as T
    }

}
