package event.pgm.fahrplan.emf2024.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.metadude.android.eventfahrplan.commons.logging.Logging
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.sharing.JsonSessionFormat
import event.pgm.fahrplan.emf2024.sharing.SimpleSessionFormat

class StarredListViewModelFactory(

    private val appRepository: AppRepository

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val logging = Logging.get()
        @Suppress("UNCHECKED_CAST")
        return StarredListViewModel(
            repository = appRepository,
            executionContext = AppExecutionContext,
            logging = logging,
            simpleSessionFormat = SimpleSessionFormat(),
            jsonSessionFormat = JsonSessionFormat()
        ) as T
    }

}
