package event.pgm.fahrplan.emf2024.about

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import event.pgm.fahrplan.emf2024.R
import event.pgm.fahrplan.emf2024.commons.ExternalNavigation
import event.pgm.fahrplan.emf2024.commons.ExternalNavigator
import event.pgm.fahrplan.emf2024.commons.ResourceResolver
import event.pgm.fahrplan.emf2024.commons.ResourceResolving

class AboutDialog : DialogFragment() {

    companion object {
        const val FRAGMENT_TAG = "AboutDialog"
    }

    private lateinit var resourceResolving: ResourceResolving
    private lateinit var externalNavigation: ExternalNavigation
    private val viewModel: AboutViewModel by viewModels {
        AboutViewModelFactory(resourceResolving, externalNavigation)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        resourceResolving = ResourceResolver(context)
        externalNavigation = ExternalNavigator(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.about_dialog, container, false).apply {
        findViewById<ComposeView>(R.id.about_view).apply {
            setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AboutScreen(
                    parameter = viewModel.aboutParameter.collectAsState().value,
                    onViewEvent = viewModel::onViewEvent,
                )
            }
            isClickable = true
        }
    }

    override fun onStart() {
        super.onStart()
        val width = resources.getInteger(R.integer.about_percentage_width)
        dialog?.window?.setPercentageWidth(width)
    }

}

/**
 * Sets the width of the window to a percentage of the current screen width.
 * To be invoked when the hosting activity is created.
 */
private fun Window.setPercentageWidth(percentage: Int) {
    val metrics = Resources.getSystem().displayMetrics
    val width = (metrics.widthPixels * (percentage / 100f)).toInt()
    setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
}
