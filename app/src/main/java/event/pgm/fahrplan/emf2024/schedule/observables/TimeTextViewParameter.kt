package event.pgm.fahrplan.emf2024.schedule.observables

import androidx.annotation.LayoutRes
import androidx.annotation.VisibleForTesting
import info.metadude.android.eventfahrplan.commons.temporal.Moment
import info.metadude.android.eventfahrplan.commons.temporal.Moment.Companion.MINUTES_OF_ONE_DAY
import event.pgm.fahrplan.emf2024.R
import event.pgm.fahrplan.emf2024.schedule.Conference
import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment
import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment.Companion.BOX_HEIGHT_MULTIPLIER
import event.pgm.fahrplan.emf2024.schedule.FahrplanFragment.Companion.FIFTEEN_MINUTES
import event.pgm.fahrplan.emf2024.schedule.FahrplanViewModel
import event.pgm.fahrplan.emf2024.schedule.TimeSegment

/**
 * Payload of the observable [timeTextViewParameters][FahrplanViewModel.timeTextViewParameters]
 * property in the [FahrplanViewModel] which is observed by the [FahrplanFragment].
 * Parameters to be used to inflate and configure a time text view.
 */
@Suppress("DataClassPrivateConstructor")
internal data class TimeTextViewParameter @VisibleForTesting constructor(

        @LayoutRes
        val layout: Int,
        val height: Int,
        val titleText: String

) {

    companion object {

        /**
         * Returns a list of parameters to be used to inflate and configure a time text view.
         *
         * The time text view show time information as hours and minutes at an interval of
         * [FIFTEEN_MINUTES]. All segments for an event day look the same with an exception
         * for the time text view which matches the current system time (now).
         *
         * An event day can exceed midnight.
         */
        fun parametersOf(
                nowMoment: Moment,
                conference: Conference,
                normalizedBoxHeight: Int,
                useDeviceTimeZone: Boolean
        ): List<TimeTextViewParameter> {
            val parameters = mutableListOf<TimeTextViewParameter>()
            var sessionStartsAt = conference.firstSessionStartsAt
            var sessionStartsAtMinutes = sessionStartsAt.minuteOfDay
            val timeTextViewHeight = BOX_HEIGHT_MULTIPLIER * normalizedBoxHeight
            var timeSegment: TimeSegment
            val minutesToAdd = if (conference.spansMultipleDays) MINUTES_OF_ONE_DAY else 0
            val lastSessionEndsAtMinutes = conference.lastSessionEndsAt.minuteOfDay + minutesToAdd
            while (sessionStartsAtMinutes < lastSessionEndsAtMinutes) {
                timeSegment = TimeSegment.ofMoment(sessionStartsAt)
                val isToday = nowMoment in conference.timeFrame
                val timeTextLayout = if (isToday && timeSegment.isMatched(nowMoment, FIFTEEN_MINUTES)) {
                    R.layout.time_layout_now
                } else {
                    R.layout.time_layout
                }
                val titleText = timeSegment.getFormattedText(conference.timeZoneOffset, useDeviceTimeZone)
                val parameter = TimeTextViewParameter(timeTextLayout, timeTextViewHeight, titleText)
                parameters.add(parameter)
                sessionStartsAt = sessionStartsAt.plusMinutes(FIFTEEN_MINUTES.toLong())
                sessionStartsAtMinutes += FIFTEEN_MINUTES
            }
            return parameters
        }
    }

}
