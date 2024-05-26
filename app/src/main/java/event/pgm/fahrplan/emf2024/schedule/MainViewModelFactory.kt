package event.pgm.fahrplan.emf2024.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.metadude.android.eventfahrplan.commons.logging.Logging
import event.pgm.fahrplan.emf2024.notifications.NotificationHelper
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext
import event.pgm.fahrplan.emf2024.repositories.AppRepository

internal class MainViewModelFactory(

    private val repository: AppRepository,
    private val notificationHelper: NotificationHelper

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val logging = Logging.get()
        return MainViewModel(
            repository = repository,
            notificationHelper = notificationHelper,
            executionContext = AppExecutionContext,
            logging = logging
        ) as T
    }

}
