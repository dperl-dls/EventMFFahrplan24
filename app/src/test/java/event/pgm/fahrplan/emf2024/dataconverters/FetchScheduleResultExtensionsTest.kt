package event.pgm.fahrplan.emf2024.dataconverters

import com.google.common.truth.Truth.assertThat
import info.metadude.android.eventfahrplan.network.models.HttpHeader
import org.junit.jupiter.api.Test
import info.metadude.android.eventfahrplan.network.fetching.FetchScheduleResult as NetworkFetchScheduleResult
import info.metadude.android.eventfahrplan.network.fetching.HttpStatus as NetworkHttpStatus
import event.pgm.fahrplan.emf2024.net.FetchScheduleResult as AppFetchScheduleResult
import event.pgm.fahrplan.emf2024.net.HttpStatus as AppHttpStatus

class FetchScheduleResultExtensionsTest {

    @Test
    fun networkFetchScheduleResult_toAppFetchScheduleResult() {
        val networkFetchScheduleResult = NetworkFetchScheduleResult(
                httpStatus = NetworkHttpStatus.HTTP_NOT_MODIFIED,
                scheduleXml = "<xml></xml>",
                httpHeader = HttpHeader(
                    eTag = "mno456",
                    lastModified = "2023-12-31T23:59:59+01:00",
                ),
                hostName = "example.com",
                exceptionMessage = "SSLException"
        )
        val appFetchScheduleResult = AppFetchScheduleResult(
                httpStatus = AppHttpStatus.HTTP_NOT_MODIFIED,
                hostName = "example.com",
                exceptionMessage = "SSLException"
        )
        assertThat(networkFetchScheduleResult
                .toAppFetchScheduleResult())
                .isEqualTo(appFetchScheduleResult)
    }

}
