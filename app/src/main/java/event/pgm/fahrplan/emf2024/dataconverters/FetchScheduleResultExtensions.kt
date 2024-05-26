package event.pgm.fahrplan.emf2024.dataconverters

import info.metadude.android.eventfahrplan.network.fetching.FetchScheduleResult as NetworkFetchScheduleResult
import event.pgm.fahrplan.emf2024.net.FetchScheduleResult as AppFetchScheduleResult

fun NetworkFetchScheduleResult.toAppFetchScheduleResult() = AppFetchScheduleResult(
        httpStatus = httpStatus.toAppHttpStatus(),
        hostName = hostName,
        exceptionMessage = exceptionMessage
)
