package event.pgm.fahrplan.emf2024.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import event.pgm.fahrplan.emf2024.commons.BuildConfigProvider
import event.pgm.fahrplan.emf2024.commons.ExternalNavigation
import event.pgm.fahrplan.emf2024.commons.ResourceResolving
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext

internal class AboutViewModelFactory(
    private val resourceResolving: ResourceResolving,
    private val externalNavigation: ExternalNavigation,
) : Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return AboutViewModel(
            executionContext = AppExecutionContext,
            externalNavigation = externalNavigation,
            aboutParameterFactory = AboutParameterFactory(BuildConfigProvider(), resourceResolving)
        ) as T
    }

}
