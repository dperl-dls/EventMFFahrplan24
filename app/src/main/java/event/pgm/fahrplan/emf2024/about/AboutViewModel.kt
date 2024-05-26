package event.pgm.fahrplan.emf2024.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import event.pgm.fahrplan.emf2024.about.AboutViewEvent.OnPostalAddressClick
import event.pgm.fahrplan.emf2024.commons.ExternalNavigation
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.repositories.ExecutionContext

class AboutViewModel(
    private val repository: AppRepository = AppRepository,
    private val executionContext: ExecutionContext,
    private val externalNavigation: ExternalNavigation,
    private val aboutParameterFactory: AboutParameterFactory,
) : ViewModel() {

    private val mutableAboutParameter = MutableStateFlow(AboutParameter())
    val aboutParameter = mutableAboutParameter.asStateFlow()

    init {
        launch {
            repository.meta.collect { meta ->
                mutableAboutParameter.value = aboutParameterFactory.createAboutParameter(meta)
            }
        }
    }

    fun onViewEvent(viewEvent: AboutViewEvent) {
        when (viewEvent) {
            is OnPostalAddressClick -> externalNavigation.openMap(viewEvent.textualAddress)
        }
    }

    private fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(executionContext.database, block = block)
    }

}
