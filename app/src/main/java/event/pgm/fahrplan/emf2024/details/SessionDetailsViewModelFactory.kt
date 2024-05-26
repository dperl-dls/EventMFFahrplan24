package event.pgm.fahrplan.emf2024.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import event.pgm.fahrplan.emf2024.BuildConfig
import event.pgm.fahrplan.emf2024.alarms.AlarmServices
import event.pgm.fahrplan.emf2024.navigation.C3nav
import event.pgm.fahrplan.emf2024.navigation.RoomForC3NavConverter
import event.pgm.fahrplan.emf2024.notifications.NotificationHelper
import event.pgm.fahrplan.emf2024.repositories.AppExecutionContext
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.sharing.JsonSessionFormat
import event.pgm.fahrplan.emf2024.sharing.SimpleSessionFormat
import event.pgm.fahrplan.emf2024.utils.FeedbackUrlComposer
import event.pgm.fahrplan.emf2024.utils.MarkdownConverter
import event.pgm.fahrplan.emf2024.utils.SessionPropertiesFormatter
import event.pgm.fahrplan.emf2024.utils.SessionUrlComposer

internal class SessionDetailsViewModelFactory(

    private val appRepository: AppRepository,
    private val alarmServices: AlarmServices,
    private val notificationHelper: NotificationHelper,
    private val defaultEngelsystemRoomName: String,
    private val customEngelsystemRoomName: String

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return SessionDetailsViewModel(
            repository = appRepository,
            executionContext = AppExecutionContext,
            alarmServices = alarmServices,
            notificationHelper = notificationHelper,
            sessionPropertiesFormatter = SessionPropertiesFormatter(),
            simpleSessionFormat = SimpleSessionFormat(),
            jsonSessionFormat = JsonSessionFormat(),
            feedbackUrlComposer = FeedbackUrlComposer(),
            sessionUrlComposition = SessionUrlComposer(),
            indoorNavigation = C3nav(BuildConfig.C3NAV_URL, RoomForC3NavConverter()),
            markdownConversion = MarkdownConverter,
            defaultEngelsystemRoomName = defaultEngelsystemRoomName,
            customEngelsystemRoomName = customEngelsystemRoomName
        ) as T
    }

}
