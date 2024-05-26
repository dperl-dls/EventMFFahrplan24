package event.pgm.fahrplan.emf2024.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.metadude.android.eventfahrplan.commons.logging.Logging
import event.pgm.fahrplan.emf2024.alarms.AlarmServices
import event.pgm.fahrplan.emf2024.notifications.NotificationHelper
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.sharing.JsonSessionFormat
import event.pgm.fahrplan.emf2024.sharing.SimpleSessionFormat

internal class FahrplanViewModelFactory(

    private val repository: AppRepository,
    private val alarmServices: AlarmServices,
    private val navigationMenuEntriesGenerator: NavigationMenuEntriesGenerator,
    private val defaultEngelsystemRoomName: String,
    private val customEngelsystemRoomName: String,
    private val notificationHelper: NotificationHelper

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val logging = Logging.get()
        return FahrplanViewModel(
            repository = repository,
            executionContext = AppExecutionContext,
            logging = logging,
            alarmServices = alarmServices,
            notificationHelper = notificationHelper,
            navigationMenuEntriesGenerator = navigationMenuEntriesGenerator,
            simpleSessionFormat = SimpleSessionFormat(),
            jsonSessionFormat = JsonSessionFormat(),
            scrollAmountCalculator = ScrollAmountCalculator(logging),
            defaultEngelsystemRoomName = defaultEngelsystemRoomName,
            customEngelsystemRoomName = customEngelsystemRoomName
        ) as T
    }

}
